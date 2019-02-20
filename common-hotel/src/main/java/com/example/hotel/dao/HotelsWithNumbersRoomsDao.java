package com.example.hotel.dao;

import java.util.List;
import com.example.hotel.model.HotelsWithNumberRooms;

public interface HotelsWithNumbersRoomsDao {
     List<HotelsWithNumberRooms> getHotelsAndNumberRooms(long biggerThanNumberRooms);
}
