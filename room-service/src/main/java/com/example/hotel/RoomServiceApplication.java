package com.example.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CommonHotelConfiguration.class)
public class RoomServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoomServiceApplication.class);
    }
}
