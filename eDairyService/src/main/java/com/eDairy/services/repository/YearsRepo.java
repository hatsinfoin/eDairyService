package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.Years;

public interface YearsRepo extends MongoRepository<Years, String> {

}
