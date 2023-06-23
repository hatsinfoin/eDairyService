package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.eDairy.services.model.Staff;

public interface StaffRepo extends MongoRepository<Staff,String>{
	
	

}
