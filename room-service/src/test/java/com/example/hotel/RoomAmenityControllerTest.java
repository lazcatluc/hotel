package com.example.hotel;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.hotel.model.Amenity;
import com.example.hotel.model.Room;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = RoomServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoomAmenityControllerTest extends MysqlSetup {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void canAddAndRemoveAirConditioningToRoom() {
        restTemplate.postForEntity("http://localhost:{port}/rooms/{roomId}/amenities/{airConditioning}",
                null, String.class, port, 1, "Air Conditioning");
        assertThat(restTemplate.getForEntity("http://localhost:{port}/rooms/{roomId}", Room.class, port, 1)
                .getBody().getAmenities().stream().map(Amenity::getName).anyMatch("Air Conditioning"::equals)).isTrue();
        restTemplate.delete("http://localhost:{port}/rooms/{roomId}/amenities/{airConditioning}",
                port, 1, "Air Conditioning");
        assertThat(restTemplate.getForEntity("http://localhost:{port}/rooms/{roomId}", Room.class, port, 1)
                .getBody().getAmenities().stream().map(Amenity::getName).noneMatch("Air Conditioning"::equals)).isTrue();
    }
}