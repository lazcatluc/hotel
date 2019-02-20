package com.example.hotel.dao;

import java.util.List;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.Room;

public interface RoomDao {
    List<Room> findAll();
    Room save(Room room);
    List<Room> findByHotel(Hotel hotel);
}
