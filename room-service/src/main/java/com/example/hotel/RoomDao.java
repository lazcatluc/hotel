package com.example.hotel;

import java.util.Optional;

public interface RoomDao {
    Room save(Room room);

    Optional<Room> findWithAmenities(Long roomId);
}
