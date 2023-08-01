package com.eDairy.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.StudentAttendance;
import com.eDairy.services.model.DateMonthYear;
import com.eDairy.services.model.StandardId;
import com.eDairy.services.model.StudentAttendenceStatus;
import com.eDairy.services.repository.StudentAttendanceRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;

@Service
public class StudentAttendanceService {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	@Autowired
	StudentAttendanceRepo studentAttendanceRepo;

	public List<StudentAttendance> getStudentAttendanceList() {
		return studentAttendanceRepo.findAll();
	}

	public StudentAttendance saveStudentAttendance(StudentAttendance studentAttendance) {
		return studentAttendanceRepo.save(studentAttendance);
	}

	public List<StudentAttendance> getStudentbyBranchId(String branchId) {

		System.out.println("branchId = " + branchId);
		List<StudentAttendance> stAttendance = new ArrayList<StudentAttendance>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("StudentAttendance");

		FindIterable<Document> iterable = collection.find(new Document("branchId", "NLR001"));

		AggregateIterable<Document> result = collection
				.aggregate(Arrays.asList(new Document("$match", new Document("branchId", "NLR001").append("monthYear",
						Arrays.asList(new Document("dateMonthYear", "30-1-2003"))))));
		System.out.println("after AggregateIterable ");

		result.forEach(doc -> stAttendance.add(converter.read(StudentAttendance.class, doc)));
		System.out.println("stAttendance  " + stAttendance);
		return stAttendance;
	}

	public List<StudentAttendance> getStudentbyBranchIdFind(String Cond, String Value) {

		System.out.println("Cond = " + Cond);
		List<StudentAttendance> stAttendance = new ArrayList<StudentAttendance>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("StudentAttendance");

		// FindIterable<Document> iterable = collection.find(new Document(Cond, Value));

		try {
			// FindIterable<Document> docs = collection.find(Document.parse("{ branchId :
			// 'NLR001'} ,{'branchId': 1 }"));

			// FindIterable<Document> docs = collection.find(Document.parse("{$and:
			// [{'branchId' : 'NLR001'},{'monthYear.dateMonthYear' : '30-1-2003'},{
			// 'monthYear.standardId.stAttendenceStatus.stRollNo':'NLR002RoleNumber-000'}
			// ]},{'branchId': 1}"));
			FindIterable<Document> docs = collection.find(Document.parse(
					"{$and: [{'monthYear.dateMonthYear' : '30-5-2003'},{ 'monthYear.standardId.stAttendenceStatus.stRollNo':'NLR002RoleNumber-000'} ]},{'branchId': 1}"));

			System.out.println("docs - " + docs);
			for (Document student : docs) {
				System.out.println(student.toJson());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * MongoCursor<Document> cursor = iterable.iterator();
		 * System.out.println("cursor --- "); while (cursor.hasNext()) {
		 * System.out.println(cursor.next().toJson()); }
		 */

		return stAttendance;
	}

	StudentAttendenceStatus stStatusReturn = new StudentAttendenceStatus();

	public StudentAttendance getStudentAttendanceOnDay(String branchId, String standardId, String dateMonthYear,
			String stRollNo) {

		System.out.println("Cond = " + branchId);
		System.out.println("Cond = " + standardId);
		System.out.println("Cond = " + dateMonthYear);
		System.out.println("Cond = " + stRollNo);

		StudentAttendance stAttendance = new StudentAttendance();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("StudentAttendance");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match",
				new Document("branchId", branchId).append("monthYear.dateMonthYear", dateMonthYear)
						.append("monthYear.standardId.standardId", standardId)
						.append("monthYear.standardId.stAttendenceStatus.stRollNo", stRollNo))));
		System.out.println("after AggregateIterable ");

		System.out.println(new Date());

		/*
		 * result.forEach(doc -> converter.read(StudentAttendance.class,
		 * doc).getMonthYear().getStandardId() .getStAttendenceStatus().stream()
		 * .dropWhile(stStatus -> !stStatus.getStRollNo().equalsIgnoreCase(stRollNo))
		 * .forEach(System.out::println));
		 */

		System.out.println(new Date());

		//result.forEach(doc -> System.out.println(converter.read(StudentAttendance.class, doc)));

		Iterator<Document> it = result.iterator();

		while (it.hasNext()) {
			StudentAttendance sa = converter.read(StudentAttendance.class, it.next());
			StudentAttendenceStatus temp = new StudentAttendenceStatus();
			List<StudentAttendenceStatus> lt = sa.getMonthYear().getStandardId().getStAttendenceStatus();
			System.out.println("before Size " + lt.size());
			for (int i = 0; i < lt.size(); i++) {
				System.out.println("A = " + lt.get(i).getStRollNo());
				System.out.println();
				if (lt.get(i).getStRollNo().equalsIgnoreCase(stRollNo)) {
					System.out.println("Not equeal");
					temp = lt.get(i);
					break;
				}
			}

			System.out.println("after  Size " + lt.size());

			System.out.println("after loop temp " + temp);

			sa.getMonthYear().getStandardId().setStAttendenceStatus(Arrays.asList(temp));

			System.out.println("sa " + sa);

			return sa;
		}

		System.out.println("stStatusReturn  " + stStatusReturn);
		return new StudentAttendance();

	}

	public List<StudentAttendance> getStudentAttendanceByMonth(String branchId, String standardId, String month,
			String stRollNo) {

		System.out.println("Cond = " + branchId);
		System.out.println("Cond = " + standardId);
		System.out.println("Cond = " + month);
		System.out.println("Cond = " + stRollNo);

		List<StudentAttendance> stAttendance = new ArrayList<StudentAttendance>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("StudentAttendance");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match",
				new Document("branchId", branchId).append("monthYear.month", month)
						.append("monthYear.standardId.standardId", standardId)
						.append("monthYear.standardId.stAttendenceStatus.stRollNo", stRollNo))));
		System.out.println("after AggregateIterable ");

		System.out.println(new Date());

		result.forEach(doc -> converter.read(StudentAttendance.class, doc).getMonthYear().getStandardId()
				.getStAttendenceStatus().stream()
				.dropWhile(stStatus -> !stStatus.getStRollNo().equalsIgnoreCase(stRollNo))
				.forEach(System.out::println));

		System.out.println(new Date());

		result.forEach(doc -> System.out.println(converter.read(StudentAttendance.class, doc)));

		Iterator<Document> it = result.iterator();

		while (it.hasNext()) {
			StudentAttendance sa = converter.read(StudentAttendance.class, it.next());
			StudentAttendenceStatus temp = new StudentAttendenceStatus();
			List<StudentAttendenceStatus> lt = sa.getMonthYear().getStandardId().getStAttendenceStatus();
			System.out.println("before Size " + lt.size());
			for (int i = 0; i < lt.size(); i++) {
				System.out.println("A = " + lt.get(i).getStRollNo());
				System.out.println();
				if (lt.get(i).getStRollNo().equalsIgnoreCase(stRollNo)) {
					System.out.println("Not equeal");
					temp = lt.get(i);
					break;
				}
			}

			System.out.println("after  Size " + lt.size());

			System.out.println("after loop temp " + temp);

			sa.getMonthYear().getStandardId().setStAttendenceStatus(Arrays.asList(temp));

			System.out.println("sa " + sa);
			stAttendance.add(sa);

		}

		System.out.println("stStatusReturn  " + stStatusReturn);
		return stAttendance;

	}

	public List<StudentAttendance> getStudentAttendanceByStabdaredMonth(String branchId, String standardId, String year,
			String month) {

		System.out.println("Cond = " + branchId);
		System.out.println("Cond = " + standardId);
		System.out.println("Cond = " + month);

		List<StudentAttendance> stAttendance = new ArrayList<StudentAttendance>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("StudentAttendance");

		AggregateIterable<Document> result = collection.aggregate(
				Arrays.asList(new Document("$match", new Document("branchId", branchId).append("monthYear.month", month)
						.append("monthYear.year", year).append("monthYear.standardId.standardId", standardId))));
		System.out.println("after AggregateIterable ");

		System.out.println(new Date());

		result.forEach(doc -> stAttendance.add(converter.read(StudentAttendance.class, doc)));

		System.out.println("stStatusReturn  " + stStatusReturn);
		return stAttendance;

	}

	public List<StudentAttendance> getStudentsAttendanceByDay(String branchId, String standardId,
			String dateMonthYear) {

		System.out.println("Cond = " + branchId);
		System.out.println("Cond = " + standardId);

		List<StudentAttendance> stAttendance = new ArrayList<StudentAttendance>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("StudentAttendance");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match",
				new Document("branchId", branchId).append("monthYear.dateMonthYear", dateMonthYear)
						.append("monthYear.standardId.standardId", standardId))));
		System.out.println("after AggregateIterable ");

		System.out.println(new Date());

		result.forEach(doc -> stAttendance.add(converter.read(StudentAttendance.class, doc)));

		System.out.println("stStatusReturn  " + stStatusReturn);
		return stAttendance;

	}

	public StudentAttendance createStudetnsStandOnDay() {

		String branchId = "NLR001";
		String year = "2023";

		String[] standardList = { "LKG", "UKG", "FrrstStandard", "SecondStandard", "ThirdStandard", "ForthStandard",
				"FifthStandard", "SixthStandard", "SeventhStandard", "EighthStandard", "NinethStandard",
				"TehnthStandard" };

		for (int monthLoop = 1; monthLoop <= 12; monthLoop++) {
			
			String month;
			
			if (Integer.toString(monthLoop).length() == 1) {
				month = "0"+monthLoop;
			} else {
				month = ""+monthLoop;
			}

			for (int loopday = 1; loopday < 30; loopday++) {

				String dateMonthYear;

				if (Integer.toString(loopday).length() == 1) {
					dateMonthYear = "0" + loopday + "-" + month + "-" + year;
				} else {
					dateMonthYear = loopday + "-" + month + "-" + year;
				}

				for (int loopTemp = 0; loopTemp < standardList.length; loopTemp++) {
					String standardId = standardList[loopTemp];

					MongoDatabase database = client.getDatabase("schoolcluster");
					MongoCollection<Document> collection = database.getCollection("StudentAttendance");

					System.out.println("after AggregateIterable ");

					StudentAttendance sa = new StudentAttendance();

					sa.setBranchId(branchId);
					DateMonthYear dmy = new DateMonthYear();
					dmy.setDateMonthYear(dateMonthYear);
					String[] arrOfStr = dateMonthYear.split("-");
					dmy.setDay(arrOfStr[0]);
					dmy.setMonth(arrOfStr[1]);
					dmy.setYear(arrOfStr[2]);
					dmy.setDateMonthYear(dateMonthYear);

					StandardId std = new StandardId();
					std.setStandardId(standardId);
					List<StudentAttendenceStatus> sasList = new ArrayList<StudentAttendenceStatus>();
					for (int i = 1; i <= 50; i++) {
						StudentAttendenceStatus sas = new StudentAttendenceStatus();
						sas.setStRollNo(standardId + "-StRoleNo-" + i);
						sas.setAttendanceStatus("true");
						sasList.add(sas);
					}
					std.setStAttendenceStatus(sasList);
					dmy.setStandardId(std);

					sa.setMonthYear(dmy);

					saveStudentAttendance(sa);

					System.out.println("sa  " + saveStudentAttendance(sa));

				}
			}
		}
		return saveStudentAttendance(new StudentAttendance());

	}

}
