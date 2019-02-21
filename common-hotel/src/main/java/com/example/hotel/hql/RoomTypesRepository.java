package com.example.hotel.hql;

import java.util.Optional;
import com.example.hotel.dao.RoomTypesDao;
import com.example.hotel.model.RoomTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface RoomTypesRepository extends RoomTypesDao, JpaRepository<RoomTypes, Long> {

    @Override
    default Optional<RoomTypes> getRoomType(String type) {
        return findByTypeCaseInsensitive(type.toLowerCase());
    }

    @Query("select r from RoomTypes r where lower(r.type) = :roomType")
    Optional<RoomTypes> findByTypeCaseInsensitive(@Param("roomType") String roomType);
}
