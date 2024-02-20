package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

 
import com.springboot.main.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
