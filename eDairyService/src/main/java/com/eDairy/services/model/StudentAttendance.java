package com.eDairy.services.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "StudentAttendance")
public class StudentAttendance {
	
	@Id
	private String id;
	private String branchId;
	
	private DateMonthYear monthYear;	
	 
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public DateMonthYear getMonthYear() {
		return monthYear;
	}
	public void setMonthYear(DateMonthYear monthYear) {
		this.monthYear = monthYear;
	}
	@Override
	public String toString() {
		return "StudentAttendance [id=" + id + ", branchId=" + branchId + ", monthYear=" + monthYear + "]";
	}
  	
	
}
