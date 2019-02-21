package com.example.hotel;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ReservationServiceApplication.class)
public class ReservationDaoTest extends MysqlSetup {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private HotelDao hotelDao;
    @Autowired
    private RoomTypesDao roomTypesDao;

    @Test
    public void canBookASingleRoomAtTheRitz() {
        RoomTypes roomType = roomTypesDao.getRoomType("Single").orElseThrow(AssertionError::new);
        Hotel ritz = hotelDao.findByName("Ritz").get(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        assertThat(reservationDao.bookARoom(ritz, LocalDate.parse("12-05-2018", formatter),
                LocalDate.parse("14-05-2018", formatter), "John Doe", roomType)).isPresent();
    }

}
