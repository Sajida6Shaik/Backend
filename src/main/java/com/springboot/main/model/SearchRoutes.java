package com.springboot.main.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class SearchRoutes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String SourceLocation;
	private String DestinationLocation;
	private LocalDate StartDate;
	private LocalDate EndDate;
	private int BookingId;
	
	 
	 @OneToOne
	 private Customer customer;
	 
	 
	 
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookingId() {
		return BookingId;
	}
	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public String getSourceLocation() {
		return SourceLocation;
	}
	public void setSourceLocation(String sourceLocation) {
		SourceLocation = sourceLocation;
	}
	public String getDestinationLocation() {
		return DestinationLocation;
	}
	public void setDestinationLocation(String destinationLocation) {
		DestinationLocation = destinationLocation;
	}
	public LocalDate getStartDate() {
		return StartDate;
	}
	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}
	public LocalDate getEndDate() {
		return EndDate;
	}
	public void setEndDate(LocalDate endDate) {
		EndDate = endDate;
	}
	 
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "SearchRoutes [id=" + id + ", SourceLocation=" + SourceLocation + ", DestinationLocation="
				+ DestinationLocation + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", BookingId=" + BookingId
				+ ", customer=" + customer + "]";
	}
	 
	 
	 
	 
	 
}