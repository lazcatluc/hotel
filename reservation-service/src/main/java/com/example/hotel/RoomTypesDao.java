package com.example.hotel;

import java.util.Optional;

public interface RoomTypesDao {
    Optional<RoomTypes> getRoomType(String type);
}
