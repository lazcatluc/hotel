package com.example.hotel;

import java.util.List;

public interface HotelDao {
    List<Hotel> findByName(String name);
}
