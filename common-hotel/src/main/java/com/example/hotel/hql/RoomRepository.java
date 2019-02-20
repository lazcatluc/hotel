package com.example.hotel.hql;

import com.example.hotel.dao.RoomDao;
import com.example.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

interface RoomRepository extends RoomDao, JpaRepository<Room, Long> {
}
