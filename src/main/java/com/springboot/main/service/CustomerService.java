package com.springboot.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Customer;
import com.springboot.main.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	 
	public Customer insertCustomer(Customer customer) {
		 
		return customerRepository.save(customer);
	}

	 
	//GET  ALL CUSTOMER 
	public List<Customer> getAll(Pageable pageable) {
		 
		return customerRepository.findAll(pageable).getContent();
	}


	//GET CUSTOMER BY ID
		public Customer getById(int cid) throws InvalidIdException {
			Optional<Customer>optional = customerRepository.findById(cid);
			if(!optional.isPresent())
				throw new InvalidIdException("CustomerID Invalid");
			
			 
			 return optional.get();
		}
		
		//DELETE
		public void deleteCustomer(int cid) {
			customerRepository.deleteById(cid);
			


		}
}
