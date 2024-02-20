package com.springboot.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.CustomerCar;
import com.springboot.main.model.Payment;
import com.springboot.main.model.SearchRoutes;
import com.springboot.main.repository.SearchRoutesRepository;

@Service
public class SearchRoutesService {
 	@Autowired
		private SearchRoutesRepository searchRoutesRepository;

		public SearchRoutes insertSearchRoutes(SearchRoutes search) {
			 
			return  searchRoutesRepository.save(search);
		}

		
		
		
		//GET ALL SEARCH ROUTES
				public List<SearchRoutes> getAll(Pageable pageable) {
					return searchRoutesRepository.findAll(pageable).getContent();
					 
				}

			
			//GET BY ID  SEARCHROUTES
			
			public  SearchRoutes getById(int sid) throws InvalidIdException {
				Optional< SearchRoutes>optional =  searchRoutesRepository.findById(sid);
				if(!optional.isPresent())
					throw new InvalidIdException("SearchID is Invalid");
				
				 
				 return optional.get();
			}

			
			//DELETE  SEARCH ROUTES
			
			public void deleteSearchRoutes(SearchRoutes searchRoutes) {
				 searchRoutesRepository.delete(searchRoutes);
				


				 
				 
			}




		 

}
