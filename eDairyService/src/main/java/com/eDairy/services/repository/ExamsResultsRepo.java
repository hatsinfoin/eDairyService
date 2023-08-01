package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.ExamResults;

public interface ExamsResultsRepo extends MongoRepository<ExamResults, String> {

}
