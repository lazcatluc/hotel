package com.example.hotel;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "rooms")
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private RoomTypes roomTypes;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    private double price;
    private int floor;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Reservation> reservations;


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", capacity=").append(capacity);
        sb.append(", roomTypes=").append(roomTypes);
        sb.append(", hotel=").append(hotel);
        sb.append(", price=").append(price);
        sb.append(", floor=").append(floor);
        sb.append('}');
        return sb.toString();
    }
}
