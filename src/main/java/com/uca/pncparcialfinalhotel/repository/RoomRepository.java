package com.uca.pncparcialfinalhotel.repository;

import com.uca.pncparcialfinalhotel.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {
    List<Room> findByHotelIdAndIsAvailableTrue(UUID hotelId);
}
