package com.example.hotel.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import com.example.hotel.MysqlSetup;
import com.example.hotel.model.HotelsWithNumberRooms;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HotelWithNumberRoomsDaoTest extends MysqlSetup {
    @Autowired
    private HotelsWithNumbersRoomsDao hotelsWithNumbersRoomsDao;

    @Test
    public void findsHotelsWithNumberRooms() {
        assertThat(hotelsWithNumbersRoomsDao.getHotelsAndNumberRooms(8))
                .isEqualTo(Arrays.asList(
                        new HotelsWithNumberRooms("Tongabezi", 12),
                        new HotelsWithNumberRooms("Longitude 131", 8),
                        new HotelsWithNumberRooms("Le Grand Bellevue", 8),
                        new HotelsWithNumberRooms("Belmond Grand Hotel", 8)));
    }
}
