package com.example.hotel;

import java.util.List;

public interface HotelDao {
    List<Hotel> findAll();
    List<Hotel> findAllWithRoomService();
    List<Hotel> findByPartialAddress(String partialAddress);
}
