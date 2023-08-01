package com.eDairy.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.ExamResults;
import com.eDairy.services.model.ExamResultsSujects;
import com.eDairy.services.repository.ExamsResultsRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Random;

@Service
public class ExamsResultsService {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	@Autowired
	ExamsResultsRepo examsResultsRepo;

	public List<ExamResults> getAllExamsResults() {
		return examsResultsRepo.findAll();
	}

	public ExamResults saveExamResults(ExamResults examResults) {
		System.out.println("examResults " + examResults);
		return examsResultsRepo.save(examResults);
	}

	public List<ExamResults> findByExamId(String examId) {

		System.out.println("examId = " + examId);
		final List<ExamResults> branchDetails = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("ExamResults");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
				new Document("text",
						// Search5657
						new Document("query", examId).append("path", Arrays.asList("examId"))))));
		// System.out.println("after AggregateIterable ");

		result.forEach(doc -> branchDetails.add(converter.read(ExamResults.class, doc)));

		System.out.println("branchDetails " + branchDetails);
		return branchDetails;

	}

	public List<ExamResults> createExamsResultsForBranch(String branchId) {

		String[] examID = { "FA-1", "FA-2", "FA-3", "FA-4", "SA-1", "SA-2" };
		String[] standardList = { "LKG", "UKG", "FrrstStandard", "SecondStandard", "ThirdStandard", "ForthStandard",
				"FifthStandard", "SixthStandard", "SeventhStandard", "EighthStandard", "NinethStandard",
				"TehnthStandard" };
		
		String[] subjectsList = {"GeneralAwareness","EnvironmentalScience","English","Mathematics","EVS","GK","Hindi"};
 
		for (String standard : standardList) {
			for (String examNameId : examID) {
				for (int i = 1; i <= 50; i++) {
					ExamResults exam = new ExamResults(); 
					exam.setBranchId(branchId);
					exam.setExamId(examNameId);
					exam.setStandardId(standard);
					exam.setExamDate("01-01-2023");
					exam.setAcadamicYear("2023");
					exam.setStRollNo(standard + "-StRoleNo-" + i);

					List<ExamResultsSujects> subList =  new ArrayList<ExamResultsSujects>();
					
					for (String subject : subjectsList) {

					ExamResultsSujects ers = new ExamResultsSujects();
						ers.setSubjectsId(subject);
						ers.setMaxMarks("100");
							Random randI = new Random();
							int myRandInt = randI.nextInt(100);						 
							ers.setObtainedMarks(myRandInt+"");
						if(myRandInt<50)
							ers.setObtainedGrade("C");
						else if(myRandInt>=50 && myRandInt<80)
							ers.setObtainedGrade("B");
						else
							ers.setObtainedGrade("A");
						
						subList.add(ers);
					}
						
						exam.setExamResultsSujects(subList);
					saveExamResults(exam);
				}
			}

		}

		return getAllExamsResults();

	}

}
