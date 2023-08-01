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
	public List<HolidayLists> getAllHolidaysByBranchId(String branchId) {
		return getholidayListByField("branchId",branchId);
	}

	public HolidayLists SaveHolidaysLists(HolidayLists holidayLists) {
		return holidayListsRepository.save(holidayLists);
	}
	
	public List<HolidayLists> SaveHolidaysLists(List<HolidayLists> holidayLists) {
		return holidayListsRepository.saveAll(holidayLists);
	}
	
	public void deleteHoliday(HolidayLists holidayLists) {
		  holidayListsRepository.delete(holidayLists);
	} 
	
	
	
	public  List<HolidayLists> getholidayByDate(String holidayDate) {

		return getholidayListByField("holidayDate",holidayDate);	 
	
	}
	
	public  List<HolidayLists> getholidayListByField(String fieldName,String fieldValue) {

		System.out.println("fieldValue = " + fieldValue);
		final List<HolidayLists> holidayList = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("HolidayLists");
		
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
			    new Document("text", 
			    		// Search5657
			    new Document("query",fieldValue)
			                .append("path",  Arrays.asList(fieldName))))));
		System.out.println("after AggregateIterable ");
	
		
		
		result.forEach(doc -> holidayList.add(converter.read(HolidayLists.class, doc)));
		System.out.println("student " + holidayList);
		return holidayList;
		 
	
	}
	

}
