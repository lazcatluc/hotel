package com.example.hotel;

import java.time.LocalDate;
import java.util.Optional;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.Reservation;
import com.example.hotel.model.RoomTypes;

public interface ReservationDao {

    Optional<Reservation> bookARoom(Hotel hotel, LocalDate from, LocalDate to, String name, RoomTypes type);
    void deleteAll();

}
