package com.eDairy.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.Standard;
import com.eDairy.services.model.Subjects;
import com.eDairy.services.repository.SubjectsRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@Service
public class SubjectsService {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;
	
	@Autowired
	SubjectsRepo subjectsRepo;

	public List<Subjects> getAllSubjects() {
		return subjectsRepo.findAll();
	}
//	public List<HolidayLists> getAllHolidaysByBranchId(String branchId) {
//		return getholidayListByField("branchId",branchId);
//	}

	public Subjects saveSubjects(Subjects subjects) {
		return subjectsRepo.save(subjects);
	}
	
	public List<Subjects> SaveSubjectsList(List<Subjects> subjects) {
		return subjectsRepo.saveAll(subjects);
	}

	public  List<Subjects> getSubjectsById(String subjectsId) {

		return getSubjectsByStandaredId("subjectsId",subjectsId);	 
	
	}
	
	public  List<Subjects> getSubjectsByAll() {

		return subjectsRepo.findAll();
	
	}
	
	public  List<Subjects> getSubjectsByStandaredId(String fieldName,String fieldValue) {

		System.out.println("fieldValue = " + fieldValue);
		final List<Subjects> SubjectsList = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("Subjects");
		
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
			    new Document("text", 
			    		// Search5657
			    new Document("query",fieldValue)
			                .append("path",  Arrays.asList(fieldName))))));
		System.out.println("after AggregateIterable ");
	
		
		
		result.forEach(doc -> SubjectsList.add(converter.read(Subjects.class, doc)));
		System.out.println("student " + SubjectsList);
		return SubjectsList;
		 
	
	}
	
	public void deleteSubjects(Subjects subjects) {
		subjectsRepo.delete(subjects);
	}

}
