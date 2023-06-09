package com.eDairy.services.repository;

import java.util.List;

import com.eDairy.services.model.Student;

public interface StudentSearchRepository {
	
	List<Student> findByRollNo(String rollNo);

}
