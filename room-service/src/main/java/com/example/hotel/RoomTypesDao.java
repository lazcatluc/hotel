package com.example.hotel;

import java.util.Optional;
import com.example.hotel.model.RoomTypes;

public interface RoomTypesDao {
    Optional<RoomTypes> getRoomType(String type);
}
