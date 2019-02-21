package com.example.hotel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = ReservationServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookRoomControllerTest extends MysqlSetup {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ReservationDao reservationDao;

    @After
    public void deleteReservations() {
        reservationDao.deleteAll();
    }

    @Test
    public void findsASingleRoomAtTheRitz() {
        ResponseEntity<Reservation> responseEntity = restTemplate.postForEntity(
                "http://localhost:{port}/reservation?hotelName={hotelName}&" +
                        "roomType={roomType}&guestName={guestName}&from={from}&to={to}", null, Reservation.class,
                port, "Ritz", "Single", "John Doe", "20180512", "20180514");
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Reservation reservation = responseEntity.getBody();
        assertThat(reservation.getGuest()).isEqualTo("John Doe");
    }

    @Test
    public void returnsNotFoundForNonExistentHotel() {
        String unknownHotel = "Unknown Hotel";
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                "http://localhost:{port}/reservation?hotelName={hotelName}&" +
                        "roomType={roomType}&guestName={guestName}&from={from}&to={to}", null, String.class,
                port, unknownHotel, "Single", "John Doe", "20180512", "20180514");
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(responseEntity.getBody()).isEqualTo("Hotel not found");
    }

    @Test
    public void returnsNotFoundForNonExistentRoomType() {
        String nonExistentRoomType = "Almost but not quite entirely unlike Single";
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                "http://localhost:{port}/reservation?hotelName={hotelName}&" +
                        "roomType={roomType}&guestName={guestName}&from={from}&to={to}", null, String.class,
                port, "Ritz", nonExistentRoomType, "John Doe", "20180512", "20180514");
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(responseEntity.getBody()).isEqualTo("Unknown room type");
    }

    @Test
    public void bookingTooManyRoomsInTheSamePeriodEventuallyLeadsToConflict() {
        int bookings = 0;
        ResponseEntity<String> responseEntity;
        do {
            responseEntity = restTemplate.postForEntity(
                    "http://localhost:{port}/reservation?hotelName={hotelName}&" +
                            "roomType={roomType}&guestName={guestName}&from={from}&to={to}", null, String.class,
                    port, "Ritz", "Single", "John Doe", "20180512", "20180514");
            if (responseEntity.getStatusCode() != HttpStatus.OK) {
                break;
            }
            bookings++;
        }
        while (bookings < 100);
        assertThat(bookings).isLessThan(100);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
    }
}