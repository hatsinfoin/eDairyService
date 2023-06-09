package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Student")
public class Student {

	@Id
	private String studentId;
	private String branchId;
	private String rollNo;
	private String name;
	private String course;
	private String dateofBirth;
	private String place;
	private String phoneNumber;
	private String motherName;
	private String fatherName;

	private String Gardian;

	private String Address1;
	private String Address2;

	private String Emergency;

	private String Miscellaneous;

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", branchId=" + branchId + ", rollNo=" + rollNo + ", name=" + name
				+ ", course=" + course + ", dateofBirth=" + dateofBirth + ", place=" + place + ", phoneNumber="
				+ phoneNumber + ", motherName=" + motherName + ", fatherName=" + fatherName + ", Gardian=" + Gardian
				+ ", Address1=" + Address1 + ", Address2=" + Address2 + ", Emergency=" + Emergency + ", Miscellaneous="
				+ Miscellaneous + "]";
	}
	
	

}
