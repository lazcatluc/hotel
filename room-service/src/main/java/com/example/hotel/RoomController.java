package com.example.hotel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms/{roomId}")
class RoomController {
    private final RoomDao roomDao;

    RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @GetMapping
    Room get(@PathVariable Long roomId) {
        return roomDao.findWithAmenities(roomId).orElseThrow(RoomNotFoundException::new);
    }
}
