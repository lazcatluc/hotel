package com.example.hotel.dao;

import java.util.Optional;
import com.example.hotel.model.RoomTypes;

public interface RoomTypesDao {
    Optional<RoomTypes> getRoomType(String type);
}
