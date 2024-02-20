package com.springboot.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.model.SearchRoutes;

public interface SearchRoutesRepository extends JpaRepository<SearchRoutes,Integer> {

	Optional<SearchRoutes> findById(int sid);

}
