package com.example.hotel;

import java.util.List;
import com.example.hotel.dao.HotelDao;
import com.example.hotel.model.Hotel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels/search")
class SearchHotelController {
    private final HotelDao hotelDao;

    SearchHotelController(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @GetMapping
    List<Hotel> search(@RequestParam String address) {
        return hotelDao.findByPartialAddress(address);
    }
}
