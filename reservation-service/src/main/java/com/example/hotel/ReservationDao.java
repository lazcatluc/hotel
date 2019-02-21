package com.example.hotel;

import java.time.LocalDate;
import java.util.Optional;

public interface ReservationDao {

    Optional<Reservation> bookARoom(Hotel hotel, LocalDate from, LocalDate to, String name, RoomTypes type);
    void deleteAll();

}
