package com.example.hotel.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.hotel.MysqlSetup;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.RoomTypes;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationDaoTest extends MysqlSetup {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private HotelDao hotelDao;

    @Test
    public void canBookARoomAtTheRitz() {
        RoomTypes roomType = new RoomTypes();
        roomType.setId(1L);
        roomType.setType("Single");
        Hotel ritz = hotelDao.findByName("Ritz").get(0);
        assertThat(reservationDao.bookARoom(ritz, format("12-05-2018"),
                format("14-05-2018"), "John Doe", roomType)).isNotNull();
    }

    private Date format(String s) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(s);
        } catch (ParseException e) {
            throw new IllegalStateException(e);
        }
    }
}
