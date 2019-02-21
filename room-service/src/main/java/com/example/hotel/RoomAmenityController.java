package com.example.hotel;

import com.example.hotel.dao.AmenityDao;
import com.example.hotel.dao.RoomDao;
import com.example.hotel.model.Room;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms/{roomId}/amenities/{amenity}")
class RoomAmenityController {
    private final RoomDao roomDao;
    private final AmenityDao amenityDao;

    RoomAmenityController(RoomDao roomDao, AmenityDao amenityDao) {
        this.roomDao = roomDao;
        this.amenityDao = amenityDao;
    }

    @PostMapping
    Room addAmenity(@PathVariable Long roomId, @PathVariable String amenity) {
        Room room = roomDao.findWithAmenities(roomId).orElseThrow(RoomNotFoundException::new);
        room.addAmenity(amenityDao.findOrCreate(amenity));
        return roomDao.save(room);
    }

    @DeleteMapping
    Room removeAmenity(@PathVariable Long roomId, @PathVariable String amenity) {
        Room room = roomDao.findWithAmenities(roomId).orElseThrow(RoomNotFoundException::new);
        room.removeAmenity(amenity);
        return roomDao.save(room);
    }
}
