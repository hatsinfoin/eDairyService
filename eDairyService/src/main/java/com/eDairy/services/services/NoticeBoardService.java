package com.eDairy.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.NoticeBoardDetails;
import com.eDairy.services.repository.NoticeBoardRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class NoticeBoardService {

	@Autowired
	NoticeBoardRepo noticeBoardRepo;
	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	public List<NoticeBoardDetails> getAllNotices() {
    	System.out.println(" in NoticeBoardService  getAllNotices");

    	List<NoticeBoardDetails>  l = noticeBoardRepo.findAll(); 
    	System.out.println(" in NoticeBoardService  getAllNotices");
    	System.out.println(" in NoticeBoardService  list "+l);

		return l;
	}

	public NoticeBoardDetails saveNoticeBoard(NoticeBoardDetails noticeBoardDetails) {
		return noticeBoardRepo.save(noticeBoardDetails);
	}
	
	public List<NoticeBoardDetails> getNoticeBoardsByBranchId(String branchId) {
		return getListByField("branchId",branchId);
	}
	
	
	public List<NoticeBoardDetails> getListByField(String fieldName, String branchId) {

		System.out.println("fieldName = " + fieldName);
		System.out.println("fieldValue = " + branchId);
		final List<NoticeBoardDetails> NoticeBoardList = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("NoticeBoardDetails");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
				new Document("text",
						// Search5657
						new Document("query", branchId).append("path", Arrays.asList(fieldName))))));
		System.out.println("after AggregateIterable ");

		result.forEach(doc -> NoticeBoardList.add(converter.read(NoticeBoardDetails.class, doc)));
		System.out.println("NoticeBoardList " + NoticeBoardList);
		return NoticeBoardList;	 

	}
	
}
