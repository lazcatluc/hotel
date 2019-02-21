package com.example.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

interface HotelRepository extends HotelDao, JpaRepository<Hotel, Long> {

}
