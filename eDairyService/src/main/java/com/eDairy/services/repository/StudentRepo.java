package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.Student;

public interface StudentRepo extends MongoRepository<Student, String> {
	
	Student findByRollNo(String rollNo);

}
