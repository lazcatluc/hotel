package com.example.hotel.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.hotel.MysqlSetup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomDaoTest extends MysqlSetup {

    @Autowired
    private RoomDao roomDao;

    @Test
    public void initializesAmenities() {
        assertThat(roomDao.findWithAmenities(1L).get().getAmenities()).isNotEmpty();
    }
}
