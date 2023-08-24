package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.Leave;

public interface LeaveRepo extends MongoRepository<Leave, String> {

}


