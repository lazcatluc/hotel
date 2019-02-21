package com.example.hotel.hql;

import java.util.Optional;
import com.example.hotel.dao.AmenityDao;
import com.example.hotel.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

interface AmenityRepository extends AmenityDao, JpaRepository<Amenity, Long> {

    @Override
    default Amenity findOrCreate(String name) {
        return findByName(name).orElseGet(() -> {
            Amenity amenity = new Amenity();
            amenity.setName(name);
            return save(amenity);
        });
    }

    Optional<Amenity> findByName(String name);
}
