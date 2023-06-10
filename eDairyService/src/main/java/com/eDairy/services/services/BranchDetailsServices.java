package com.eDairy.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.BranchDetails;
import com.eDairy.services.model.Student;
import com.eDairy.services.repository.BranchDetailsRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


import java.util.Arrays;
import java.util.List;


@Service
public class BranchDetailsServices {
	
	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	
	@Autowired
	BranchDetailsRepo branchDetailsRepo;

	public List<BranchDetails> getAllBranchDetails() {
		return branchDetailsRepo.findAll();
	}

	public BranchDetails saveBranchDetails(BranchDetails branchDetails) {
		System.out.println("BranchDetails "+branchDetails);
		return branchDetailsRepo.save(branchDetails);
	}
	
	
	public List<BranchDetails> findByBranchId(String branchId) {

		System.out.println("rollNo = " + branchId);
		final List<BranchDetails> branchDetails = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("BranchDetails");
		
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
			    new Document("text", 
			    		// Search5657
			    new Document("query",branchId)
			    .append("path",Arrays.asList("branchId"))))));
		//System.out.println("after AggregateIterable ");
	
		
		
				 result.forEach(doc -> branchDetails.add(converter.read(BranchDetails.class,doc)));

		System.out.println("student " + branchDetails);
		return branchDetails;
	
	
	

}
	
}
