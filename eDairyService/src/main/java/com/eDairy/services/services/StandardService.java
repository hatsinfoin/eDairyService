package com.eDairy.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.Standard;
import com.eDairy.services.model.StandardSubjects;
import com.eDairy.services.repository.StandardRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@Service
public class StandardService {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;
	
	@Autowired
	StandardRepo standardRepo;

	public List<Standard> getAllStandards() {
		return standardRepo.findAll();
	}
//	public List<HolidayLists> getAllHolidaysByBranchId(String branchId) {
//		return getholidayListByField("branchId",branchId);
//	}

	public Standard saveStandard(Standard standard) {
		return standardRepo.save(standard);
	}
	
	public List<Standard> saveStandardLists(List<Standard> Standard) {
		return standardRepo.saveAll(Standard);
	}
	
	public void deleteStandard(Standard Standard) {
		 standardRepo.delete(Standard);
	}
	

	public  List<StandardSubjects> getStandardById(String standardId) {

		return getSubjectsByStandardId("standardId",standardId);	 
	
	}
	
	public  List<StandardSubjects> findAllSubjectsByStandardId(String standardId) {
		System.out.println("findAllSubjectsByStandardId in standardId "+standardId);
		return getSubjectsByStandardId("standardId",standardId);	 
	
	}
	
	
	public  List<Standard> getStandardByAll() {

		return standardRepo.findAll();
	
	}
	
	public Set<String>  getAllUniqueStandardsBrBrnch(String branchId) {
		
		System.out.println("branchId = " + branchId);
  		Set<String> uniqueStandared = new HashSet<String>();
		final List<Standard> standardList = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("Standard");
		
		AggregateIterable<Document> result = collection.aggregate( Arrays.asList(new Document("$match", 
			    new Document("branchId", branchId))));
		System.out.println("after AggregateIterable ");
	
		
		
		result.forEach(doc -> uniqueStandared.add(converter.read(Standard.class,doc).getStandardId()));
		System.out.println("standardList  2 " + standardList);
		System.out.println("uniqueStandared  " + uniqueStandared);
		return uniqueStandared;
	}
	
	public  List<StandardSubjects> getSubjectsByStandardId(String fieldName,String fieldValue) {

		System.out.println("fieldName = " + fieldName);
		System.out.println("fieldValue = " + fieldValue);
		final List<StandardSubjects> standardList = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("Standard");
		
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match", 
			    new Document("standardId", fieldValue)), 
			    new Document("$lookup", 
			    new Document("from", "Subjects")
			            .append("localField", fieldName)
			            .append("foreignField", fieldName)
			            .append("as", "subjects"))));
		System.out.println("after AggregateIterable ");
	
		
		
		result.forEach(doc -> standardList.add(converter.read(StandardSubjects.class, doc)));
		System.out.println("student " + standardList);
		return standardList;
		 
	
	}
	
	public  List<StandardSubjects> findByStandardID(String standardId) {

		System.out.println("In findByStandardID standardId = " + standardId);
 		final List<StandardSubjects> standardList = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("Standard");
		
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match", 
			    new Document("standardId", standardId).append("branchId", "NRL001"))));
		System.out.println("after AggregateIterable ");
	
		
		
		result.forEach(doc -> standardList.add(converter.read(StandardSubjects.class, doc)));
		System.out.println("standardList " + standardList);
		return standardList;
		 
	
	}
	
	
	/*Arrays.asList(new Document("$match", 
		    new Document("standardId", "FirstStandard")
		            .append("branchId", "NRL001")), 
		    new Document("$lookup", 
		    new Document("from", "Subjects")
		            .append("localField", "standardId")
		            .append("foreignField", "standardId")
		            .append("as", "Subjects")), 
		    new Document("$lookup", 
		    new Document("from", "HolidayLists")
		            .append("localField", "branchId")
		            .append("foreignField", "branchId")
		            .append("as", "HolidayLists")), 
		    new Document("$lookup", 
		    new Document("from", "NoticeBoardDetails")
		            .append("localField", "branchId")
		            .append("foreignField", "branchId")
		            .append("as", "NoticeBoardDetails")))
	*/
	
	

}
