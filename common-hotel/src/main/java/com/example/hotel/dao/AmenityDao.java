package com.example.hotel.dao;

import com.example.hotel.model.Amenity;

public interface AmenityDao {
    Amenity findOrCreate(String name);
}
