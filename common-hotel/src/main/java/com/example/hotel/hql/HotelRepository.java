package com.example.hotel.hql;

import java.util.List;
import com.example.hotel.dao.HotelDao;
import com.example.hotel.dao.HotelsWithNumbersRoomsDao;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.HotelsWithNumberRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface HotelRepository extends HotelDao, HotelsWithNumbersRoomsDao, JpaRepository<Hotel, Long> {

    @Override
    @Query("select h from Hotel h " +
            "join h.rooms r " +
            "join r.amenities a "+
            "where a.name = 'Room Service' " +
            "group by h.name " +
            "order by h.name")
    List<Hotel> findAllWithRoomService();

    @Override
    @Query("select new com.example.hotel.model.HotelsWithNumberRooms(h.name, count(r)) " +
            "from Hotel h join h.rooms r " +
            "group by h having count(r) >= :biggerThanNumberRooms")
    List<HotelsWithNumberRooms> getHotelsAndNumberRooms(@Param("biggerThanNumberRooms") long biggerThanNumberRooms);
}
