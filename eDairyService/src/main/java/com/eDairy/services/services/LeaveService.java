package com.eDairy.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.Leave;
import com.eDairy.services.repository.LeaveRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class LeaveService {

	@Autowired
	LeaveRepo leaveRepo;
	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	public List<Leave> getAllEDairy() {
		System.out.println(" in NoticeBoardService  getAllNotices");

		List<Leave> l = leaveRepo.findAll();
		System.out.println(" in NoticeBoardService  getAllNotices");
		System.out.println(" in NoticeBoardService  list " + l);

		return l;
	}

	public Leave saveLeave(Leave leave) {
		return leaveRepo.save(leave);
	}

//	public List<Leave> searchLeveBy(String branchId, String examId, String standardId,
//			String acadamicYear, String Leaveby)
//
//	{
//
//		// System.out.println("examId = " + examId);
//		// final ExamResults LeaveStatus = new ArrayList<>();
//
//		List<Leave> LeaveStatus = new ArrayList<>();
//
//		MongoDatabase database = client.getDatabase("schoolcluster");
//		MongoCollection<Document> collection = database.getCollection("Leave");
//
//		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match",
////			    new Document("branchId", "NLR001")
////			            .append("examId", "FA-1")
////			            .append("standardId", "LKG")
////			            .append("acadamicYear", "2023")
////			            .append("stRollNo", "LKG-StRoleNo-1"))));
////		 new Document("branchId", "NLR001")
//				new Document("branchId", branchId).append("examId", examId).append("standardId", standardId)
//						.append("acadamicYear", acadamicYear).append("Leaveby", Leaveby))));
//
//		result.forEach(doc -> LeaveStatus.add(converter.read(Leave.class, doc)));
//
//		System.out.println("LeaveStatus " + LeaveStatus);
//		return LeaveStatus; 
//
//	}

	public List<Leave> getLeaveByDate(String leaveId, String academicYear, String standardId,
			String branchId, String leaveby) {
//		return getListByField("branchId",branchId);
//	}

		final List<Leave> LeaveStatus = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("Leave");

		System.out.println("eDairyId " + leaveId);
		System.out.println("academicYear " + academicYear);
		System.out.println("standardId " + standardId);
		System.out.println("branchId " + branchId);
		System.out.println("subjectID " + leaveId);

//		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match",
//				new Document("LeaveId", leaveId).append("academicYear", academicYear).append("standardId", standardId)
//						.append("branchId", branchId)
//						.append("leaveby", "RoleNumber-002"))));
		
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match", 
			    new Document("LeaveId",leaveId)
			            .append("academicYear",academicYear)
			            .append("standardId",standardId)
			            .append("branchId",branchId)
			            .append("Leaveby",leaveby))));
		result.forEach(doc -> LeaveStatus.add(converter.read(Leave.class, doc)));

		System.out.println("result " + result.toString());
		System.out.println("LeaveStatus " + LeaveStatus);
		return LeaveStatus;

	}

//	public List<EDairy> getStudentAttendanceByStabdaredMonth(String branchId, String standardId, String year,
//			String month) {
//
//		System.out.println("Cond = " + branchId);
//		System.out.println("Cond = " + standardId);
//		System.out.println("Cond = " + month);
//
//		List<StudentAttendance> stAttendance = new ArrayList<StudentAttendance>();
//
//		MongoDatabase database = client.getDatabase("schoolcluster");
//		MongoCollection<Document> collection = database.getCollection("StudentAttendance");
//
//		AggregateIterable<Document> result = collection.aggregate(
//				Arrays.asList(new Document("$match", new Document("branchId", branchId).append("monthYear.month", month)
//						.append("monthYear.year", year).append("monthYear.standardId.standardId", standardId))));
//		System.out.println("after AggregateIterable ");
//
//		System.out.println(new Date());
//
//		result.forEach(doc -> stAttendance.add(converter.read(StudentAttendance.class, doc)));
//
//		System.out.println("stStatusReturn  " + stStatusReturn);
//		return stAttendance;
//
//	}
//

//	public List<NoticeBoardDetails> getNoticeBoardsByBranchId(String branchId) {
//		return getListByField("branchId",branchId);
//	}

//	public List<NoticeBoardDetails> getListByField(String fieldName, String branchId) {
//
//		System.out.println("fieldName = " + fieldName);
//		System.out.println("fieldValue = " + branchId);
//		final List<NoticeBoardDetails> NoticeBoardList = new ArrayList<>();
//
//		MongoDatabase database = client.getDatabase("schoolcluster");
//		MongoCollection<Document> collection = database.getCollection("NoticeBoardDetails");
//
//		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
//				new Document("text",
//						// Search5657
//						new Document("query", branchId).append("path", Arrays.asList(fieldName))))));
//		System.out.println("after AggregateIterable ");
//
//		result.forEach(doc -> NoticeBoardList.add(converter.read(NoticeBoardDetails.class, doc)));
//		System.out.println("NoticeBoardList " + NoticeBoardList);
//		return NoticeBoardList;	 
//
//	}	
}
