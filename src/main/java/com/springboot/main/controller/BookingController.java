package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Admin;
import com.springboot.main.model.Booking;
import com.springboot.main.model.Car;
import com.springboot.main.model.Customer;
import com.springboot.main.model.CustomerCar;
import com.springboot.main.service.BookingService;
import com.springboot.main.service.CarService;
import com.springboot.main.service.CustomerService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	 
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CarService carService;
	

	@PostMapping("booking/add/{cid}/{carid}")
	public ResponseEntity<?> insertCustomerCar(@PathVariable("cid") int cid,@PathVariable("carid") int carid,
			@RequestBody Booking booking) {
		try {
		Customer customer =customerService.getById(cid);
		Car car = carService.getById(carid);
		booking.setCarId(carid);
		booking.setCustomer(customer);
		booking=bookingService.insertBooking(booking);
		return ResponseEntity.ok().body(booking);
		}catch(InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	//GET ALL  BOOKINGS
		@GetMapping("/booking/all")

		public List<Booking> getAllBookings(@RequestParam(value= "page",required = false,defaultValue ="0")Integer page,
			                    @RequestParam(value="size",required = false, defaultValue = "1000000" )Integer size) {
			
			
			Pageable pageable = PageRequest.of(page,size);
			return bookingService.getAllBooking(pageable);
			
		}
		
		//GET ONE  BOOKINGS
		
		@GetMapping("/booking/getone/{bid}")
		public ResponseEntity<?> getone(@PathVariable("bid")int bid) throws InvalidIdException {
			try {
		       Booking  booking =bookingService.getById(bid);
			return ResponseEntity.ok().body( booking);
		}
		catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
				
		}
		}
		//UPDATE BOOKING
		@PutMapping("/booking/update/{bid}")   
		public ResponseEntity<?> updateBooking(@PathVariable("bid") int bid,
								@RequestBody Booking  bookingDto) throws InvalidIdException {
			//validate id
			Booking booking = bookingService.getById(bid);

			 
			
			
			if( bookingDto.getBookingStatus() != null)
				 booking.setBookingStatus(bookingDto.getBookingStatus());
				 
			 
			
			if( bookingDto.getDropOfLocation() != null)
				bookingDto.setDropOfLocation(bookingDto.getDropOfLocation());
			
			
			if( bookingDto.getPickupLocation() != null)
				bookingDto.setPickupLocation(bookingDto.getPickupLocation());
			
			if( bookingDto.getFromDate() != null)
				bookingDto.setFromDate(bookingDto.getFromDate());
			
			if( bookingDto.getToDate() != null)
				bookingDto.setToDate(bookingDto.getToDate());
			
			if( bookingDto.getPrice() != 0)
				bookingDto.setPrice(bookingDto.getPrice());
			
			
			
			 
			bookingDto = bookingService.insertBooking( bookingDto); 
			return ResponseEntity.ok().body( bookingDto);
		}
		 


	@DeleteMapping("/booking/delete/{bid}")
	public ResponseEntity<?> deleteBooking(@PathVariable("bid") int bid) throws InvalidIdException {
		
		//validate id
		Booking booking = bookingService.getById(bid);
		//delete
	bookingService.deleteBooking(booking);
		return ResponseEntity.ok().body("Booking deleted successfully");
	}
	}


