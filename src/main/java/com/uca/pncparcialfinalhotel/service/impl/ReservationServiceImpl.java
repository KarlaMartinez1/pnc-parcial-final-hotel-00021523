package com.uca.pncparcialfinalhotel.service.impl;

import com.uca.pncparcialfinalhotel.entities.Reservation;
import com.uca.pncparcialfinalhotel.entities.Room;
import com.uca.pncparcialfinalhotel.entities.User;
import com.uca.pncparcialfinalhotel.repository.ReservationRepository;
import com.uca.pncparcialfinalhotel.repository.RoomRepository;
import com.uca.pncparcialfinalhotel.repository.UserRepository;
import com.uca.pncparcialfinalhotel.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Reservation createReservation(UUID userId, UUID roomId, Reservation reservationDetails) {
        User guest = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));

        if (!room.getIsAvailable()) {
            throw new RuntimeException("La habitación no está disponible");
        }

        reservationDetails.setGuest(guest);
        reservationDetails.setRoom(room);
        reservationDetails.setStatus("CONFIRMED");

        room.setIsAvailable(false);
        roomRepository.save(room);

        return reservationRepository.save(reservationDetails);
    }
}
