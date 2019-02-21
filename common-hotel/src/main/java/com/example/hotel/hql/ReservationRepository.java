package com.example.hotel.hql;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.example.hotel.dao.ReservationDao;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.Reservation;
import com.example.hotel.model.Room;
import com.example.hotel.model.RoomTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface ReservationRepository extends ReservationDao, JpaRepository<Reservation, Long> {

    @Override
    default Optional<Reservation> bookARoom(Hotel hotel, LocalDate from, LocalDate to, String name, RoomTypes type) {
        return findAvailableRoom(type, hotel, to, from).stream().findAny().map(
                room -> {
                    Reservation reservation = new Reservation();
                    reservation.setGuest(name);
                    reservation.setFrom(from);
                    reservation.setTo(to);
                    reservation.setRoom(room);

                    return save(reservation);
                });
    }

    @Query("select r from Room r left join fetch r.amenities " +
            "where r.roomTypes = :roomTypes and r.hotel =:hotel " +
            "and r not in (select r1 from Room r1 " +
            "join r1.reservations re " +
            "where re.from < :toDate and re.to > :fromDate)")
    List<Room> findAvailableRoom(@Param("roomTypes") RoomTypes roomTypes, @Param("hotel") Hotel hotel,
                                 @Param("toDate") LocalDate toDate, @Param("fromDate") LocalDate fromDate);
}
