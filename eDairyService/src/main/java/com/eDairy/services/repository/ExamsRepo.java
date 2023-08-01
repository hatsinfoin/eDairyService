package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.Exams;

public interface ExamsRepo extends MongoRepository<Exams, String> {

}
