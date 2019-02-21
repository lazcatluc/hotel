package com.example.hotel;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface HotelRepository extends HotelDao, JpaRepository<Hotel, Long> {

    @Override
    @Query("select h from Hotel h " +
            "join h.rooms r " +
            "join r.amenities a "+
            "where a.name = 'Room Service' " +
            "group by h.name " +
            "order by h.name")
    List<Hotel> findAllWithRoomService();


    @Query("select h from Hotel h where " +
            "lower(h.address.country) like :partialAddress or " +
            "lower(h.address.city) like :partialAddress or " +
            "lower(h.address.street) like :partialAddress")
    List<Hotel> findByEscapedPartialAddress(@Param("partialAddress") String partialAddress);

    @Override
    default List<Hotel> findByPartialAddress(String partialAddress) {
        return findByEscapedPartialAddress('%' + partialAddress.toLowerCase() + '%');
    }

}
