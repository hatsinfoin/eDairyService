package com.eDairy.services.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExamResultsSujects {

 	private String obtainedMarks;
	private String obtainedGrade;
	private String maxMarks;
	private String subjectsId;
	public String getObtainedMarks() {
		return obtainedMarks;
	}
	public void setObtainedMarks(String obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	public String getObtainedGrade() {
		return obtainedGrade;
	}
	public void setObtainedGrade(String obtainedGrade) {
		this.obtainedGrade = obtainedGrade;
	}
	public String getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getSubjectsId() {
		return subjectsId;
	}
	public void setSubjectsId(String subjectsId) {
		this.subjectsId = subjectsId;
	}
	@Override
	public String toString() {
		return "ExamResultsSujects [obtainedMarks=" + obtainedMarks + ", obtainedGrade=" + obtainedGrade + ", maxMarks="
				+ maxMarks + ", subjectsId=" + subjectsId + "]";
	}
	
	 
}
