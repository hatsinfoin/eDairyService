package com.eDairy.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.ExamResults;
import com.eDairy.services.model.Exams;
import com.eDairy.services.model.ExamsModel;
import com.eDairy.services.model.StudentAttendance;
import com.eDairy.services.repository.ExamsRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class ExamsServices {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	@Autowired
	ExamsRepo examsRepo;

	public List<Exams> getAllExams() {
		return examsRepo.findAll();
	}

	public Exams saveExams(Exams exam) {
		System.out.println("Exams " + exam);
		return examsRepo.save(exam);
	}

	public List<Exams> findByExamId(String examId) {

		System.out.println("examId = " + examId);
		final List<Exams> branchDetails = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("Exams");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
				new Document("text",
						// Search5657
						new Document("query", examId).append("path", Arrays.asList("examId"))))));
		// System.out.println("after AggregateIterable ");

		result.forEach(doc -> branchDetails.add(converter.read(Exams.class, doc)));

		System.out.println("branchDetails " + branchDetails);
		return branchDetails;

	}

	public List<Exams> createExamsForBranch(String branchId) {

		String[] examID = { "FA-1","FA-2","FA-3","FA-4", "SA-1", "SA-2" };
		String[] standardList = { "LKG", "UKG", "FrrstStandard", "SecondStandard", "ThirdStandard", "ForthStandard",
				"FifthStandard", "SixthStandard", "SeventhStandard", "EighthStandard", "NinethStandard",
				"TehnthStandard" };

		for (String standard : standardList) {
			for (String examNameId : examID) {
				Exams exam = new Exams();
				exam.setBranchId(branchId);
				exam.setExamId(examNameId);
				exam.setExamName(examNameId);
				exam.setStandardId(standard);
				exam.setExamType(examNameId);
				exam.setExamGroupName(examNameId);
				exam.setExamDate("01-01-2023");
				saveExams(exam);
			}
		}

		return getAllExams();		
//		
	}
	
	public List<ExamsModel> getStAttExamResultsByBranchStdExam(String branchId, String standardId, String ExamId,String studentId) {

		System.out.println("Cond = " + branchId);
		System.out.println("Cond = " + standardId);
		
		List<ExamsModel> stExams = new ArrayList<ExamsModel>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("Exams");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match", 
			    new Document("branchId", "NLR001")
	            .append("standardId", "LKG")
	            .append("examName", "FA-1")), 
	    new Document("$lookup", 
	    new Document("from", "ExamResults")
	            .append("localField", "examId")
	            .append("foreignField", "examId")
	            .append("as", "examResults"))));

		System.out.println(new Date());

		result.forEach(doc -> stExams.add(converter.read(ExamsModel.class, doc)));
				
		System.out.println("stExams output -->  " + stExams);
		return stExams;

	}
	

}
