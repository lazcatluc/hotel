package com.example.hotel;

import java.util.Optional;
import com.example.hotel.model.Room;

public interface RoomDao {
    Room save(Room room);

    Optional<Room> findWithAmenities(Long roomId);
}
