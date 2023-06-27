package com.eDairy.services.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
 public class BranchDetailsStudentList {
	
 	private String id;
	private String branchId;
	private String brName;
	private String brAddress1;
	private String brPhoneNumber;
	private String brAddress2;
	private String brPinNumber;
	private String brState;
	private List<Student> student;
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
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getBrAddress1() {
		return brAddress1;
	}
	public void setBrAddress1(String brAddress1) {
		this.brAddress1 = brAddress1;
	}
	public String getBrPhoneNumber() {
		return brPhoneNumber;
	}
	public void setBrPhoneNumber(String brPhoneNumber) {
		this.brPhoneNumber = brPhoneNumber;
	}
	public String getBrAddress2() {
		return brAddress2;
	}
	public void setBrAddress2(String brAddress2) {
		this.brAddress2 = brAddress2;
	}
	public String getBrPinNumber() {
		return brPinNumber;
	}
	public void setBrPinNumber(String brPinNumber) {
		this.brPinNumber = brPinNumber;
	}
	public String getBrState() {
		return brState;
	}
	public void setBrState(String brState) {
		this.brState = brState;
	}
	
	
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "BranchDetailsStudentList [id=" + id + ", branchId=" + branchId + ", brName=" + brName + ", brAddress1="
				+ brAddress1 + ", brPhoneNumber=" + brPhoneNumber + ", brAddress2=" + brAddress2 + ", brPinNumber="
				+ brPinNumber + ", brState=" + brState + ", student=" + student + "]";
	}
	 
	 
 	
	

}
