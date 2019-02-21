package com.example.hotel;

import java.util.List;
import com.example.hotel.model.Hotel;

public interface HotelDao {
    List<Hotel> findAll();
    List<Hotel> findAllWithRoomService();
    List<Hotel> findByPartialAddress(String partialAddress);
}
