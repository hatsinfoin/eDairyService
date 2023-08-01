package com.eDairy.services.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
  public class ExamsModel {
	
	@Id
	private String id;
 	private String examId;
	private String examName;
 	private String examType;
 	private String standardId;	
	private String branchId;
	private String examDate;
	private String examGroupName;
	private ArrayList<ExamResultsModel> examResults;
	
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
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
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
	public String getExamGroupName() {
		return examGroupName;
	}
	public void setExamGroupName(String examGroupName) {
		this.examGroupName = examGroupName;
	}
	
	
	public ArrayList<ExamResultsModel> getExamResults() {
		return examResults;
	}
	public void setExamResults(ArrayList<ExamResultsModel> examResults) {
		this.examResults = examResults;
	}
	@Override
	public String toString() {
		return "Exams [id=" + id + ", examId=" + examId + ", examName=" + examName + ", examType=" + examType
				+ ", standardId=" + standardId + ", branchId=" + branchId + ", examDate=" + examDate
				+ ", examGroupName=" + examGroupName + "]";
	}
	
	 
	

}
