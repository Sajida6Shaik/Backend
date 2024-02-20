package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	//GET ALL  CUSTOMERS
	@GetMapping("/customer/getall")
	public List<Customer> getAllCustomer() {
		return customerService.getAll() ;
		
		
	}

	

}
