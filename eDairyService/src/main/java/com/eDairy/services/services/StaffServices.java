package com.eDairy.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.Staff;
import com.eDairy.services.repository.StaffRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class StaffServices {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	@Autowired
	StaffRepo staffRepo;

	public List<Staff> getAllStaffs() {
		return staffRepo.findAll();
	}

	public Staff saveOfficeStaff(Staff staff) {
		System.out.println("BranchDetails " + staff);
		return staffRepo.save(staff);
	}

	public List<Staff> findByStaffId(String staffId) {

		System.out.println("rollNo = " + staffId);
		final List<Staff> officeStaff = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("Staff");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
				new Document("text",
						// Search5657
						new Document("query", staffId).append("path", Arrays.asList("staffId"))))));
		// System.out.println("after AggregateIterable ");

		result.forEach(doc -> officeStaff.add(converter.read(Staff.class, doc)));

		System.out.println("student " + officeStaff);
		return officeStaff;

	}

}
