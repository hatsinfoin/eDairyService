package com.eDairy.services.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eDairy.services.model.DateMonthYear;
import com.eDairy.services.model.StandardId;
import com.eDairy.services.model.StudentAttendance;
import com.eDairy.services.model.StudentAttendenceStatus;
import com.eDairy.services.services.StudentAttendanceService;

@RestController
@RequestMapping("/v1/studentAttendance")
public class StudentAttendanceController {

	private final StudentAttendanceService studentAttendanceService;

	public StudentAttendanceController(StudentAttendanceService studentAttendanceService) {
		this.studentAttendanceService = studentAttendanceService;
	}

	@GetMapping("/getStudentAttendanceList")
	public ResponseEntity<List<StudentAttendance>> getAllNotices() {
		return ResponseEntity.ok(studentAttendanceService.getStudentAttendanceList());
	}

	@GetMapping("/getStudentbyBranchId/{branchId}")
	public ResponseEntity<List<StudentAttendance>> getStudentbyBranchId(@PathVariable String branchId) {
		return ResponseEntity.ok(studentAttendanceService.getStudentbyBranchId(branchId));
	}

	@PostMapping("/saveHolidaysList")
	public ResponseEntity<StudentAttendance> saveNoticeBoard(@RequestBody StudentAttendance studentAttendance) {
		System.out.println("studentAttendance  - " + studentAttendance);
		return ResponseEntity.ok(studentAttendanceService.saveStudentAttendance(studentAttendance));
	}

	/*
	 * @GetMapping("/createStudentAttendance") public
	 * ResponseEntity<List<StudentAttendance>> createStudentAttendance() {
	 * StudentAttendance sa1 = new StudentAttendance();
	 * 
	 * for (int month = 1; month <= 12; month++) { StudentAttendance sa = new
	 * StudentAttendance(); sa.setBranchId("NLR001"); for (int day = 1; day <= 30;
	 * day++) { sa.setYear("2013"); sa.setMonth(Integer.toString(month));
	 * sa.setDay(Integer.toString(day));
	 * 
	 * DateMonthYear d = new DateMonthYear(); d.setDateMonthYear(day + "-06-2023");
	 * StandardId std = new StandardId(); std.setStandardId("UKG"); for (int j = 0;
	 * j <= 10; j++) { if (std.getStAttendenceStatus() == null) {
	 * List<StudentAttendenceStatus> l = new ArrayList<StudentAttendenceStatus>();
	 * l.add(createAttendenceStatus("RoleNumber-00" + j, "true"));
	 * std.setStAttendenceStatus(l); } else { System.out.println("sdfsdfs");
	 * System.out.println(std.getStAttendenceStatus());
	 * std.getStAttendenceStatus().add(createAttendenceStatus(("RoleNumber-00" + j),
	 * "true")); } }
	 * 
	 * if (d.getStandardId() == null) { List<StandardId> l = new
	 * ArrayList<StandardId>(); l.add(std); d.setStandardId(l); } else {
	 * d.getStandardId().add(std); }
	 * 
	 * // d.getStandardId().add(std); // d.setStandardId(Arrays.asList(std));
	 * 
	 * if (sa.getMonthYear() == null) { List<DateMonthYear> l = new
	 * ArrayList<DateMonthYear>(); l.add(d); sa.setMonthYear(l); } else {
	 * sa.getMonthYear().add(d); }
	 * 
	 * // sa.setMonthYear(Arrays.asList(d)); } System.out.println("sa -> " + sa);
	 * studentAttendanceService.saveStudentAttendance(sa); sa1=sa; } return
	 * ResponseEntity.ok(Arrays.asList(sa1)); }
	 */
	
	@GetMapping("/createStudentAttendance")
	public ResponseEntity<List<StudentAttendance>> createStudentAttendance() {
		StudentAttendance sa1 = new StudentAttendance();
		int year=2004;
		for (int month = 1; month <= 12; month++) {
		StudentAttendance sa = new StudentAttendance();
		sa.setBranchId("NLR001");
		for (int day = 1; day <= 30; day++) {		 

			DateMonthYear d = new DateMonthYear();
			d.setDateMonthYear(day + "-"+month+"-"+year);
			d.setDay(Integer.toString(day));
			d.setYear(Integer.toString(year));
			d.setMonth(Integer.toString(month));
			StandardId std = new StandardId();
			
			if(day%2 == 0)
				std.setStandardId("UKG");
			else
				std.setStandardId("LKG");

			for (int j = 0; j <= 10; j++) {
				if (std.getStAttendenceStatus() == null) {
					List<StudentAttendenceStatus> l = new ArrayList<StudentAttendenceStatus>();
					l.add(createAttendenceStatus("RoleNumber-00" + j, "true"));
					std.setStAttendenceStatus(l);
				} else {
					System.out.println("sdfsdfs");
					System.out.println(std.getStAttendenceStatus());
					std.getStAttendenceStatus().add(createAttendenceStatus(("RoleNumber-00" + j), "true"));
				}
			}

			d.setStandardId(std);
			 
			sa.setMonthYear(d);

			// sa.setMonthYear(Arrays.asList(d));
			
			studentAttendanceService.saveStudentAttendance(sa);

		}
		System.out.println("sa -> " + sa);
		//studentAttendanceService.saveStudentAttendance(sa);
		sa1=sa;
		}
		return ResponseEntity.ok(Arrays.asList(sa1));
	}
	
	
	@GetMapping("/createYearStudentAttendance")
	public ResponseEntity<List<StudentAttendance>> createYearStudentAttendance() {
		StudentAttendance sa1 = new StudentAttendance();
		int year=2004;
		for (int month = 1; month <= 12; month++) {
		StudentAttendance sa = new StudentAttendance();
		sa.setBranchId("NLR001");
		for (int day = 1; day <= 30; day++) {		 

			DateMonthYear d = new DateMonthYear();
			d.setDateMonthYear(day + "-"+month+"-"+year);
			d.setDay(Integer.toString(day));
			d.setYear(Integer.toString(year));
			d.setMonth(Integer.toString(month));
			StandardId std = new StandardId();
			
			if(day%2 == 0)
				std.setStandardId("UKG");
			else
				std.setStandardId("LKG");

			for (int j = 0; j <= 10; j++) {
				if (std.getStAttendenceStatus() == null) {
					List<StudentAttendenceStatus> l = new ArrayList<StudentAttendenceStatus>();
					l.add(createAttendenceStatus("RoleNumber-00" + j, "true"));
					std.setStAttendenceStatus(l);
				} else {
					System.out.println("sdfsdfs");
					System.out.println(std.getStAttendenceStatus());
					std.getStAttendenceStatus().add(createAttendenceStatus(("RoleNumber-00" + j), "true"));
				}
			}

			d.setStandardId(std);
			 
			sa.setMonthYear(d);

			// sa.setMonthYear(Arrays.asList(d));
			
			studentAttendanceService.saveStudentAttendance(sa);

		}
		System.out.println("sa -> " + sa);
		//studentAttendanceService.saveStudentAttendance(sa);
		sa1=sa;
		}
		return ResponseEntity.ok(Arrays.asList(sa1));
	}
	

	public StudentAttendenceStatus createAttendenceStatus(String roleNumber, String status) {
		StudentAttendenceStatus sas = new StudentAttendenceStatus();
		System.out.println("createAttendenceStatus  roleNumber " + roleNumber);
		sas.setStRollNo("NLR002" + roleNumber);
		sas.setAttendanceStatus(status);
		return sas;
	}

	
	@GetMapping("/findStudentAttendance/{Cond}/{Value}")
	public ResponseEntity<List<StudentAttendance>> getStudentbyBranchIdFind(@PathVariable String Cond,@PathVariable String Value) {
		
		studentAttendanceService.getStudentbyBranchIdFind(Cond,Value);
		
		return null;		
	}
	
	
	@GetMapping("/getStudentAttendanceOnDay/{branchId}/{standardId}/{dateMonthYear}/{stRollNo}")
	public ResponseEntity<StudentAttendance> getStudentAttendanceOnDay(@PathVariable String branchId,@PathVariable String standardId,@PathVariable String dateMonthYear,@PathVariable String stRollNo) {
		
		return ResponseEntity.ok(studentAttendanceService.getStudentAttendanceOnDay( branchId,  standardId,  dateMonthYear, stRollNo));
			 		
	}
	
	
	@GetMapping("/getStudentAttendanceByMonth/{branchId}/{standardId}/{month}/{stRollNo}")
	public ResponseEntity<List<StudentAttendance>> getStudentAttendanceByMonth(@PathVariable String branchId,@PathVariable String standardId,@PathVariable String month,@PathVariable String stRollNo) {
		
		return ResponseEntity.ok(studentAttendanceService.getStudentAttendanceByMonth( branchId,  standardId,  month, stRollNo));
			 		
	} 
	@GetMapping("/getStudentAttendanceByStabdaredMonth/{branchId}/{standardId}/{year}/{month}")
	public ResponseEntity<List<StudentAttendance>> getStudentAttendanceByStabdaredMonth(@PathVariable String branchId,@PathVariable String standardId,@PathVariable String year,@PathVariable String month) {
		
		return ResponseEntity.ok(studentAttendanceService.getStudentAttendanceByStabdaredMonth( branchId,  standardId, year, month));
			 		
	}
	
	@GetMapping("/getStudentsAttendanceByDay/{branchId}/{standardId}/{dateMonthYear}")
	public ResponseEntity<List<StudentAttendance>> getStudentsAttendanceByDay(@PathVariable String branchId,@PathVariable String standardId,@PathVariable String dateMonthYear) {
		
		return ResponseEntity.ok(studentAttendanceService.getStudentsAttendanceByDay( branchId,  standardId, dateMonthYear));
			 		
	}
	
	@GetMapping("/createStudetnsStandOnDay")
	public ResponseEntity<StudentAttendance> createStudetnsStandOnDay() {
		
		return ResponseEntity.ok(studentAttendanceService.createStudetnsStandOnDay());
			 		
	}
	
	
	/*
	 * @GetMapping("/getholidayByDate/{holidayDate}") public
	 * ResponseEntity<List<HolidayLists>> getholidayByDate(@PathVariable String
	 * holidayDate) { return
	 * ResponseEntity.ok(holidayListsServices.getholidayByDate(holidayDate)); }
	 * 
	 * @PostMapping("/deleteHoliday") public ResponseEntity<String>
	 * deleteHoliday(@RequestBody HolidayLists holidayLists) {
	 * System.out.println("HolidayLists  - "+holidayLists);
	 * holidayListsServices.deleteHoliday(holidayLists); return
	 * ResponseEntity.ok("OK"); }
	 */
}
