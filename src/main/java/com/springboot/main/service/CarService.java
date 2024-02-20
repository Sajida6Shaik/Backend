package com.springboot.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Car;
import com.springboot.main.repository.CarRepository;
@Service
public class CarService {
	 
	@Autowired
	private CarRepository carRepository;
	 
	public Car insertCar(Car car) {
		 
		return carRepository.save(car);
	}
	
	//GET ALL CARS

	public List<Car> getAll(Pageable pageable) {
		 return carRepository.findAll(pageable).getContent();
	}
	
	//GET CAR BY ID

		public Car getById(int carid) throws InvalidIdException {
			Optional<Car>optional =carRepository.findById(carid) ;
			if(!optional.isPresent())
				throw new InvalidIdException("CarID is Invalid");
			 
			return optional.get();
		}
	
	  
	
	//TO DELETE A CAR
	
	

		public void deleteCar(int carid) {
			carRepository.deleteById(carid);
			
			 
		}

		 
}
