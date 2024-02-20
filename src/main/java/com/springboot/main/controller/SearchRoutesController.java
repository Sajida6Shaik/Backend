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

import com.springboot.main.dto.SearchRoutesDto;
import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Booking;
import com.springboot.main.model.Car;
import com.springboot.main.model.Customer;
import com.springboot.main.model.SearchRoutes;
import com.springboot.main.service.BookingService;
import com.springboot.main.service.CarService;
import com.springboot.main.service.CustomerService;
import com.springboot.main.service.SearchRoutesService;

@RestController
public class SearchRoutesController {
	@Autowired
	private SearchRoutesService searchRoutesService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BookingService bookingService;
 
	
	
	 
//	 
//	 
//	
////	@PostMapping("/searchRoutes/add")
////	public SearchRoutes insertSearchRoutes(@RequestBody SearchRoutes searchRoutes) {
////		return searchRoutesService.insertSearchRoutes(searchRoutes);
////	}
//	
 
	@PostMapping("/SearchRoutes/add/{cid}/{bid}")
	public ResponseEntity<?> insertSearchRoutes(@PathVariable("cid") int cid,@PathVariable("bid") int bid, 
			@RequestBody SearchRoutes searchRoutes) {
		try {
		Customer customer =customerService.getById(cid);
		Booking booking = bookingService.getById(bid);
		 
		searchRoutes.setCustomer(customer);
		searchRoutes.setBookingId(bid);
		
	 searchRoutes= searchRoutesService.insertSearchRoutes( searchRoutes);
		return ResponseEntity.ok().body( searchRoutes);
		}catch(InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	

	//GET ALL SEARCH ROUTES
	
	@GetMapping("/SearchRoutes/getall")  
	public List<SearchRoutes> getAll(@RequestParam(value="page",required = false, defaultValue = "0") Integer page,
							   @RequestParam(value="size", required = false, defaultValue = "10000000") Integer size) {  
		Pageable pageable = PageRequest.of(page, size);  
		return searchRoutesService.getAll(pageable);
	}
	
	
	
	//GET ONE SEARCH
	
	@GetMapping("/SearchRoutes/getone/{sid}")
	public ResponseEntity<?> getone(@PathVariable("sid")int sid) throws InvalidIdException {
		try {
	     SearchRoutes searchRoutes =searchRoutesService.getById(sid);
		return ResponseEntity.ok().body(searchRoutes);
	}
	catch (InvalidIdException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
			
	}
	}
		
		
		//UPDATE SEARCH ROUTES
		
		
		@PutMapping("/SearchRoutes/update/{sid}")   
		public ResponseEntity<?> updateSearchRoutes(@PathVariable("sid") int sid,
								@RequestBody SearchRoutesDto searchRoutesDto) throws InvalidIdException   {
			try {
				//validate id
				 SearchRoutes  searchRoutes = searchRoutesService.getById(sid);
				
				if( searchRoutesDto.getBookingId()!= 0)
					searchRoutesDto.setBookingId(searchRoutesDto.getBookingId());

				if(  searchRoutesDto .getSourceLocation()!= null)
					 searchRoutesDto.setSourceLocation(searchRoutesDto.getSourceLocation());
				
				if(  searchRoutesDto .getDestinationLocation()!= null)
					 searchRoutesDto.setDestinationLocation(searchRoutesDto.getDestinationLocation());
				
				
				if(  searchRoutesDto .getStartDate()!= null)
					 searchRoutesDto.setStartDate(searchRoutesDto.getStartDate());
				
				
				if(  searchRoutesDto .getEndDate()!= null)
					 searchRoutesDto.setEndDate(searchRoutesDto.getEndDate());
				  
				searchRoutes =searchRoutesService.insertSearchRoutes( searchRoutes); 
				return ResponseEntity.ok().body( searchRoutesDto);
			}catch(InvalidIdException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
	 
		}
				
			 
		
		//DELETE AN SEARCH ROUTES
		
				@DeleteMapping("/SearchRoutes/delete/{sid}")
				public ResponseEntity<?> deleteSearchRoutes(@PathVariable("sid") int sid) throws InvalidIdException {
					
					//validate id
					SearchRoutes searchRoutes = searchRoutesService.getById(sid);
					//delete
					searchRoutesService.deleteSearchRoutes(searchRoutes);
					return ResponseEntity.ok().body("SearchRoutes deleted successfully");
				}
			
		
		
		
		
		
		
		
		
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
	
	

 
