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
import com.eDairy.services.model.BranchDetailsStudentList;
import com.eDairy.services.repository.BranchDetailsRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
		System.out.println("BranchDetails " + branchDetails);
		return branchDetailsRepo.save(branchDetails);
	}

	public List<BranchDetails> findByBranchId(String branchId) {

		System.out.println("branchId = " + branchId);
		final List<BranchDetails> branchDetails = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("BranchDetails");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
				new Document("text",
						// Search5657
						new Document("query", branchId).append("path", Arrays.asList("branchId"))))));
		// System.out.println("after AggregateIterable ");

		result.forEach(doc -> branchDetails.add(converter.read(BranchDetails.class, doc)));

		System.out.println("branchDetails " + branchDetails);
		return branchDetails;

	}

	public List<BranchDetailsStudentList> findAllBStudentsByBranchId(String branchId) {

		System.out.println("branchId = " + branchId);
		final List<BranchDetailsStudentList> branchDetails = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("BranchDetails");

		AggregateIterable<Document> result = collection
				.aggregate(
						Arrays.asList(
								new Document("$search",
								new Document("text",new Document("query", branchId).append("path", "branchId"))),
								new Document("$lookup", new Document("from", "Student").append("localField", "branchId")
								.append("foreignField", "branchId").append("as", "student"))));	
		
		 System.out.println("Branch Details Student details result "+result);		

		result.forEach(doc -> branchDetails.add(converter.read(BranchDetailsStudentList.class, doc)));

		System.out.println("branchDetails " + branchDetails);
		return branchDetails;

	}

}
