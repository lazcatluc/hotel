package com.example.hotel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RoomServiceApplication.class)
public class RoomDaoTest extends MysqlSetup {

    @Autowired
    private RoomDao roomDao;

    @Test
    public void initializesAmenities() {
        assertThat(roomDao.findWithAmenities(1L).get().getAmenities()).isNotEmpty();
    }
}
