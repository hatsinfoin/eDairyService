package com.eDairy.services.services;

import com.eDairy.services.model.Student;
import com.eDairy.services.repository.StudentSearchRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StudentSearchRepositoryImpl implements StudentSearchRepository {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	@Override
	public List<Student> findByRollNo(String rollNo) {

		System.out.println("rollNo = " + rollNo);
		final List<Student> student = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("Student");
		
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
			    new Document("text", 
			    		// Search5657
			    new Document("query",rollNo)
			                .append("path",  Arrays.asList("rollNo", "name"))))));
		System.out.println("after AggregateIterable ");
	
		
		
		result.forEach(doc -> student.add(converter.read(Student.class, doc)));
		System.out.println("student " + student);
		return student;
		
//
//		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", new Document(
//				"rollNo",
//				new Document("$sort", new Document("query", rollNo).append("path", Arrays.asList("rollNo")))))));
//
//		System.out.println("after AggregateIterable ");
//
//		result.forEach(doc -> student.add(converter.read(Student.class, doc)));
//		System.out.println("student " + student);
//		return student;
		
		

	}

}
