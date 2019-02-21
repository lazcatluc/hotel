package com.example.hotel;

import java.time.LocalDate;
import com.example.hotel.dao.HotelDao;
import com.example.hotel.dao.ReservationDao;
import com.example.hotel.dao.RoomTypesDao;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.Reservation;
import com.example.hotel.model.RoomTypes;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
class BookRoomController {

    private final HotelDao hotelDao;
    private final RoomTypesDao roomTypesDao;
    private final ReservationDao reservationDao;

    BookRoomController(HotelDao hotelDao, RoomTypesDao roomTypesDao, ReservationDao reservationDao) {
        this.hotelDao = hotelDao;
        this.roomTypesDao = roomTypesDao;
        this.reservationDao = reservationDao;
    }

    @PostMapping
    ResponseEntity<Reservation> reserve(@RequestParam String hotelName, @RequestParam String roomType,
                                        @RequestParam String guestName,
                                        @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate from,
                                        @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate to) {
        Hotel hotel = hotelDao.findByName(hotelName).stream().findFirst().orElseThrow(HotelNotFoundException::new);
        RoomTypes roomTypes = roomTypesDao.getRoomType(roomType).orElseThrow(RoomTypesNotFoundException::new);
        return ResponseEntity.ok(reservationDao.bookARoom(hotel, from, to, guestName, roomTypes)
                .orElseThrow(ReservationNotPossibleException::new));
    }

    @ExceptionHandler(HotelNotFoundException.class)
    ResponseEntity<String> handleHotelNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel not found");
    }

    @ExceptionHandler(RoomTypesNotFoundException.class)
    ResponseEntity<String> handleRoomTypesNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown room type");
    }

    @ExceptionHandler(ReservationNotPossibleException.class)
    ResponseEntity<String> handleReservationNotPossible() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("No free rooms available");
    }
}
