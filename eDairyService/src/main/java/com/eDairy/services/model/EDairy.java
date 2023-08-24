package com.eDairy.services.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EDairy")
public class EDairy {

	@Id
	private String id;
	private String eDairyId;
	private String academicYear;
	private String standardId;
	private String branchId;
	private String eDairyDetails;
	private String subjectId;
	private String dateOfAssignment;
	private ArrayList<EDairyStudentStatus> eDairyStudentStatus;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String geteDairyId() {
		return eDairyId;
	}
	public void seteDairyId(String eDairyId) {
		this.eDairyId = eDairyId;
	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	public String getStandardId() {
		return standardId;
	}
	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String geteDairyDetails() {
		return eDairyDetails;
	}
	public void seteDairyDetails(String eDairyDetails) {
		this.eDairyDetails = eDairyDetails;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getDateOfAssignment() {
		return dateOfAssignment;
	}
	public void setDateOfAssignment(String dateOfAssignment) {
		this.dateOfAssignment = dateOfAssignment;
	}
	public ArrayList<EDairyStudentStatus> geteDairyStudentStatus() {
		return eDairyStudentStatus;
	}
	public void seteDairyStudentStatus(ArrayList<EDairyStudentStatus> eDairyStudentStatus) {
		this.eDairyStudentStatus = eDairyStudentStatus;
	}
	
	

}