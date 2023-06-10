package com.eDairy.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.HolidayLists;
import com.eDairy.services.model.Student;
import com.eDairy.services.repository.HolidayListsRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@Service
public class HolidayListsServices {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;
	
	@Autowired
	HolidayListsRepository holidayListsRepository;

	public List<HolidayLists> getAllHolidays() {
		return holidayListsRepository.findAll();
	}

	public HolidayLists SaveHolidaysLists(HolidayLists holidayLists) {
		return holidayListsRepository.save(holidayLists);
	}
	
	public List<HolidayLists> SaveHolidaysLists(List<HolidayLists> holidayLists) {
		return holidayListsRepository.saveAll(holidayLists);
	}

	public  List<HolidayLists> getholidayByDate(String holidayDate) {


		System.out.println("holidayDate = " + holidayDate);
		final List<HolidayLists> student = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("HolidayLists");
		
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
			    new Document("text", 
			    		// Search5657
			    new Document("query",holidayDate)
			                .append("path",  Arrays.asList("holidayDate"))))));
		System.out.println("after AggregateIterable ");
	
		
		
		result.forEach(doc -> student.add(converter.read(HolidayLists.class, doc)));
		System.out.println("student " + student);
		return student;
		 
	
	}
	
	
	

}
