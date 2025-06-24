package com.icwd.hotel.service.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icwd.hotel.service.HotelService.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {

}
