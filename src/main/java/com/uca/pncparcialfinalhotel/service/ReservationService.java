package com.uca.pncparcialfinalhotel.service;

import com.uca.pncparcialfinalhotel.entities.Reservation;

import java.util.UUID;

public interface ReservationService {
    Reservation createReservation(UUID userId, UUID roomId, Reservation reservationDetails);
}
