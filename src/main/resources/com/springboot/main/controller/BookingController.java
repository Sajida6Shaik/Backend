package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Booking;
import com.springboot.main.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	//POST BOOKING
	
	@PostMapping("/Booking/add")
	public Booking insertBooking(@RequestBody Booking booking) {
		return bookingService.insertBooking(booking);
	}
	
	

	//GET ALL Bookings
		@GetMapping("/Bookings/all")

		public List<Booking> getAllBookings(@RequestParam(value= "page",required = false,defaultValue ="0")Integer page,
			                    @RequestParam(value="size",required = false, defaultValue = "1000000" )Integer size) {
			
			
			Pageable pageable = PageRequest.of(page,size);
			return bookingService.getAllBooking(pageable);
			
		}
		
		
	

}
