package com.example.hotel.dao;

import java.util.Date;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.Reservation;
import com.example.hotel.model.RoomTypes;

public interface ReservationDao {

    Reservation bookARoom(Hotel hotel, Date from, Date to, String name, RoomTypes type);

}
