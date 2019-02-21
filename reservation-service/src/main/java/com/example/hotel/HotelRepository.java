package com.example.hotel;

import com.example.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

interface HotelRepository extends HotelDao, JpaRepository<Hotel, Long> {

}
