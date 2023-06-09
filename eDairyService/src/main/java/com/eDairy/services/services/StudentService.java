package com.eDairy.services.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.Student;
import com.eDairy.services.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo  studentRepo;

	public Optional<Student> getByStudentId(String Id) {
		return studentRepo.findById(Id);
	}

	
	
	public  Student  SaveStudentDetails(Student student) {
		
		
		return studentRepo.save(student);
	}
	
	
//	public boolean CheckStudentExists(Student student)
//	{  
//		student.
//		
//	if(studentRepo.findByRollNo().equalsIgnoreCase(username)) {
//		System.out.println(" Found user "+username);
//		user = tempUser;
//		break;
//	}

}
