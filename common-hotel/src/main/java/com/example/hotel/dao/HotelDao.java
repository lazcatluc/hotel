package com.example.hotel.dao;

import java.util.List;
import com.example.hotel.model.Hotel;

public interface HotelDao {
    List<Hotel> findAll();
    List<Hotel> findAllWithRoomService();
    List<Hotel> findByName(String name);
    List<Hotel> findByPartialAddress(String partialAddress);
}
