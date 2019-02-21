package com.example.hotel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelServiceApplication.class)
public class HotelDaoTest {

    @Autowired
    private HotelDao hotelDao;

    @Test
    public void findsRoomServiceHotels() {
        assertThat(hotelDao.findAllWithRoomService().size()).isEqualTo(4);
    }

    @Test
    public void findsAllHotels() {
        assertThat(hotelDao.findAll().size()).isEqualTo(8);
    }

    @Test
    public void findsHotelsInRome() {
        assertThat(hotelDao.findByPartialAddress("Rome").size()).isEqualTo(3);
    }
}
