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

import com.springboot.main.dto.CustomerDto;
import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Car;
import com.springboot.main.model.Customer;
import com.springboot.main.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer/add")
	public Customer insertCustomer(@RequestBody Customer customer) {
		return customerService.insertCustomer(customer);
	}
	
	
	//GET ALL   CUSTOMERS
		@GetMapping("/customer/all")

		public List<Customer> getAllCustomers(@RequestParam(value= "page",required = false,defaultValue ="0")Integer page,
			                    @RequestParam(value="size",required = false, defaultValue = "1000000" )Integer size) {
			
			
			Pageable pageable = PageRequest.of(page,size);
			return customerService.getAll(pageable);
			
		}
		
		

		//GET CUSTOMER BY ID
@GetMapping("/customer/one/{cid}")
public ResponseEntity<?> getById(@PathVariable("cid")int cid) {
	 
	try {
		Customer customer = customerService.getById(cid);
			
		return ResponseEntity.ok().body(customer);
		
			
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
}

//UPDATE CUSTOMER

@PutMapping("/customer/update/{cid}")
public ResponseEntity<?> updateCustomer(@PathVariable("cid") int cid,@RequestBody CustomerDto customerDto){
	try {
		Customer customer = customerService.getById(cid);
		if(customerDto.getAge()!=0)
			customer.setAge(customerDto.getAge());
		if(customerDto.getCity()!=null)
			customer.setCity(customerDto.getCity());
		if(customerDto.getArea()!=null)
			customer.setArea(customerDto.getArea());
		if(customerDto.getDate()!=null)
			customer.setDate(customerDto.getDate());
		if(customerDto.getEmailId()!=null)
			customer.setEmailId(customerDto.getEmailId());
		customer=customerService.insertCustomer(customer);
		return ResponseEntity.ok().body(customer);	
	}catch(InvalidIdException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}


//DELETE A CUSTOMER

		@DeleteMapping("/delete/{cid}")
		public ResponseEntity<?> deleteCustomer(@PathVariable("cid") int cid) {
			try {
				 Customer customer = customerService.getById(cid);
				customerService.deleteCustomer(cid);
				return ResponseEntity.ok().body("Customer is Deleted");
			} catch (InvalidIdException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}
		
		 
			 
}
 




