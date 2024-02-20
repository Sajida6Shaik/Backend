package com.springboot.main.dto;

import java.time.LocalDate;

import com.springboot.main.model.Car;
import com.springboot.main.model.Customer;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class CustomerCarDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDate date;


    @OneToOne
    private Customer customer;

    @OneToOne
    private Car car;
    
    
    
    //Generate Setters and getters
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
    
    
    
    
    
}

	


