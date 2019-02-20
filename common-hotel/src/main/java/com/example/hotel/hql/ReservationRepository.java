package com.example.hotel.hql;

import java.util.Date;
import java.util.List;
import com.example.hotel.dao.ReservationDao;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.Reservation;
import com.example.hotel.model.Room;
import com.example.hotel.model.RoomTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface ReservationRepository extends ReservationDao, JpaRepository<Reservation, Long> {

    @Override
    default Reservation bookARoom(Hotel hotel, Date from, Date to, String name, RoomTypes type) {
        List<Room> rooms = findAvailableRoom(type, hotel, to, from);
        if(rooms.isEmpty()) {
            return null;
        }
        Reservation reservation = new Reservation();
        reservation.setGuest(name);
        reservation.setFrom(from);
        reservation.setTo(to);
        reservation.setRoom(rooms.get(0));

        return save(reservation);
    }

    @Query("select r from Room r " +
            "where r.roomTypes = :roomTypes and r.hotel =:hotel" +
            " and r not in (select r1 from Room r1 " +
                            "join r1.reservations re " +
                            "where re.from < :toDate and re.to > :fromDate)")
    List<Room> findAvailableRoom(RoomTypes roomTypes, Hotel hotel, Date toDate, Date fromDate);
}
