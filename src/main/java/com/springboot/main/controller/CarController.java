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
import com.springboot.main.model.Car;
import com.springboot.main.service.CarService;

@RestController
public class CarController {
	@Autowired
	private CarService carService;

	@PostMapping("/car/add")
	public Car insertCar(@RequestBody Car car) {
		return carService.insertCar(car);
	}
	
	
	//GET ALL   CARS
		@GetMapping("/car/all")

		public List<Car> getAllCars(@RequestParam(value= "page",required = false,defaultValue ="0")Integer page,
			                    @RequestParam(value="size",required = false, defaultValue = "1000000" )Integer size) {
			
			
			Pageable pageable = PageRequest.of(page,size);
			return carService.getAll(pageable);
			
		}
		
		
		
		
		@GetMapping("/car/one/{carid}")
		
		public ResponseEntity<?> getById(@PathVariable("carid")int carid) {
			 
			try {
				Car car = carService.getById(carid);
					
				return ResponseEntity.ok().body(car);
				
					
				} catch (InvalidIdException e) {
					return ResponseEntity.badRequest().body(e.getMessage());
				}
				}
			
			
			//UPDATE CAR
		 
			@PutMapping("/car/update/{carid}")
			public ResponseEntity<?>UpdateCar(@PathVariable ("carid")int carid,
										 @RequestBody Car newCar){
			
			try {
				Car car = carService.getById(carid);
			//car model
				if(newCar.getCarModel()!=null)
				car.setCarModel(newCar.getCarModel());
				//price
				
				if(newCar.getPrice()!=0)
					car.setPrice(newCar.getPrice());
				//Mileage
					if(newCar.getMileage()!=0)
					car.setMileage(newCar.getMileage());
					//FuelType
				
				if(newCar.getFuelType()!=null)
					car.setFuelType(newCar.getFuelType());
				//Seating
				
				if(newCar.getSeating()!=0)
					car.setSeating(newCar.getSeating());
				//Insurance
					
				if(newCar.getInsurance()!=null)
					car.setInsurance(newCar.getInsurance()); 
				
				car = carService.insertCar(car);
				
				return ResponseEntity.ok().body(car);
					
				  
			}catch(InvalidIdException e) {
					return ResponseEntity.badRequest().body(e.getMessage());
			}	
			} 
			
	 

		//DELETE A CAR
		 
		@DeleteMapping("/delete/{carid}")
		public ResponseEntity<?> deleteCar(@PathVariable("carid") int carid) {
			try {
				 Car car = carService.getById(carid);
				carService.deleteCar(carid);
				return ResponseEntity.ok().body("Car is Deleted");
			} catch (InvalidIdException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}
	}	
		
		
		

