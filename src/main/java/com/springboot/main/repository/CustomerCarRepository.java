package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.model.CustomerCar;

public interface CustomerCarRepository extends JpaRepository<CustomerCar, Integer> {

}
