package com.example.hotel;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import com.example.hotel.model.Hotel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = HotelServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchHotelControllerTest extends MysqlSetup {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findsEscondidoInKentucky() {
        ResponseEntity<List<Hotel>> responseEntity = restTemplate.exchange(
                "http://localhost:{port}/hotels/search?address={address}",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Hotel>>() {
                }, port, "kentucky");

        assertThat(responseEntity.getBody().get(0).getName()).isEqualTo("Hotel Escondido");
    }
}