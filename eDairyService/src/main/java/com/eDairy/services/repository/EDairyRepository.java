package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.EDairy;


public interface EDairyRepository extends MongoRepository<EDairy,String>{
	
	

}







