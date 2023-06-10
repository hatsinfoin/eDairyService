package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.BranchDetails;

public interface BranchDetailsRepo extends MongoRepository<BranchDetails,String>{
	
	

}
