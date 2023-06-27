package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.Standard;

public interface StandardRepo extends MongoRepository<Standard,String>{
	
	

}
