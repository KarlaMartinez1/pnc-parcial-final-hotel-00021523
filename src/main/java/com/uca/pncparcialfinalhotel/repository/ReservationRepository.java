package com.uca.pncparcialfinalhotel.repository;

import com.uca.pncparcialfinalhotel.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    List<Reservation> findByGuestId(UUID guestId);
}
