package com.example.hotel;

import java.util.Optional;
import com.example.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface RoomRepository extends RoomDao, JpaRepository<Room, Long> {
    @Override
    @Query("select r from Room r left join fetch r.amenities where r.id = :roomId")
    Optional<Room> findWithAmenities(@Param("roomId") Long roomId);
}
