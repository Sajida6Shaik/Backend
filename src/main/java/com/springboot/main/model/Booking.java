package com.springboot.main.model;

 
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int BookingId;
	 
	private double Price;
	private LocalDate FromDate;
	private LocalDate ToDate;
	private String PickupLocation;
	private String DropOfLocation;
	private String BookingStatus;
	private int CarId;
	 
	
	@OneToOne
	private Customer customer;
	public int getCarId() {
		return CarId;
	}


	public void setCarId(int carId) {
		CarId = carId;
	}

 
	public int getBookingId() {
		return BookingId;
	}


	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}

 

	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		Price = price;
	}


	public LocalDate getFromDate() {
		return FromDate;
	}


	public void setFromDate(LocalDate fromDate) {
		FromDate = fromDate;
	}


	public LocalDate getToDate() {
		return ToDate;
	}


	public void setToDate(LocalDate toDate) {
		ToDate = toDate;
	}


	public String getPickupLocation() {
		return PickupLocation;
	}


	public void setPickupLocation(String pickupLocation) {
		PickupLocation = pickupLocation;
	}


	public String getDropOfLocation() {
		return DropOfLocation;
	}


	public void setDropOfLocation(String dropOfLocation) {
		DropOfLocation = dropOfLocation;
	}


	public String getBookingStatus() {
		return BookingStatus;
	}


	public void setBookingStatus(String bookingStatus) {
		BookingStatus = bookingStatus;
	}


	 

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Booking [BookingId=" + BookingId + ", Price=" + Price + ", FromDate=" + FromDate + ", ToDate=" + ToDate
				+ ", PickupLocation=" + PickupLocation + ", DropOfLocation=" + DropOfLocation + ", BookingStatus="
				+ BookingStatus + ", customer=" + customer + "]";
	}


	 
 
}