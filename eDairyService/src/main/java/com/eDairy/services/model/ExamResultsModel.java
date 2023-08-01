package com.eDairy.services.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
 public class ExamResultsModel {

	@Id
	private String id;
	private String examId;
	private String standardId;
	private String branchId;
	private String examDate;
	private String acadamicYear;
	private String stRollNo;

	private List<ExamResultsSujects> examResultsSujects;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
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

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getAcadamicYear() {
		return acadamicYear;
	}

	public void setAcadamicYear(String acadamicYear) {
		this.acadamicYear = acadamicYear;
	}

	public String getStRollNo() {
		return stRollNo;
	}

	public void setStRollNo(String stRollNo) {
		this.stRollNo = stRollNo;
	}

	public List<ExamResultsSujects> getExamResultsSujects() {
		return examResultsSujects;
	}

	public void setExamResultsSujects(List<ExamResultsSujects> examResultsSujects) {
		this.examResultsSujects = examResultsSujects;
	}

	@Override
	public String toString() {
		return "ExamResults [id=" + id + ", examId=" + examId + ", standardId=" + standardId + ", branchId=" + branchId
				+ ", examDate=" + examDate + ", acadamicYear=" + acadamicYear + ", stRollNo=" + stRollNo
				+ ", examResultsSujects=" + examResultsSujects + "]";
	}
 
	
	
}
