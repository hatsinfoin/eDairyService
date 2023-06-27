package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.Subjects;

public interface SubjectsRepo extends MongoRepository<Subjects,String>{
}
