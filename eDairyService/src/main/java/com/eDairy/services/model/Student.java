package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Student")
public class Student {

	@Id
	private String id;
 	private String stRollNo;
	private String stNaame;
 	private String stDateofBirth;
	private String stAddres1;
	private String stAddres2;
	private String stPhoneNumber;
	private String stMotherName;
	private String stFatherName;
	private String stGender;
	private String stPincode;
	private String stEmergencyContNumber;
	private String gardian;
	private String standardId;	
	private String branchId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStRollNo() {
		return stRollNo;
	}
	public void setStRollNo(String stRollNo) {
		this.stRollNo = stRollNo;
	}
	public String getStNaame() {
		return stNaame;
	}
	public void setStNaame(String stNaame) {
		this.stNaame = stNaame;
	}
	public String getStDateofBirth() {
		return stDateofBirth;
	}
	public void setStDateofBirth(String stDateofBirth) {
		this.stDateofBirth = stDateofBirth;
	}
	public String getStAddres1() {
		return stAddres1;
	}
	public void setStAddres1(String stAddres1) {
		this.stAddres1 = stAddres1;
	}
	public String getStAddres2() {
		return stAddres2;
	}
	public void setStAddres2(String stAddres2) {
		this.stAddres2 = stAddres2;
	}
	public String getStPhoneNumber() {
		return stPhoneNumber;
	}
	public void setStPhoneNumber(String stPhoneNumber) {
		this.stPhoneNumber = stPhoneNumber;
	}
	public String getStMotherName() {
		return stMotherName;
	}
	public void setStMotherName(String stMotherName) {
		this.stMotherName = stMotherName;
	}
	public String getStFatherName() {
		return stFatherName;
	}
	public void setStFatherName(String stFatherName) {
		this.stFatherName = stFatherName;
	}
	public String getStGender() {
		return stGender;
	}
	public void setStGender(String stGender) {
		this.stGender = stGender;
	}
	public String getStPincode() {
		return stPincode;
	}
	public void setStPincode(String stPincode) {
		this.stPincode = stPincode;
	}
	public String getStEmergencyContNumber() {
		return stEmergencyContNumber;
	}
	public void setStEmergencyContNumber(String stEmergencyContNumber) {
		this.stEmergencyContNumber = stEmergencyContNumber;
	}
	public String getGardian() {
		return gardian;
	}
	public void setGardian(String gardian) {
		this.gardian = gardian;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	
	public String getStandardId() {
		return standardId;
	}
	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stRollNo=" + stRollNo + ", stNaame=" + stNaame + ", stDateofBirth="
				+ stDateofBirth + ", stAddres1=" + stAddres1 + ", stAddres2=" + stAddres2 + ", stPhoneNumber="
				+ stPhoneNumber + ", stMotherName=" + stMotherName + ", stFatherName=" + stFatherName + ", stGender="
				+ stGender + ", stPincode=" + stPincode + ", stEmergencyContNumber=" + stEmergencyContNumber
				+ ", gardian=" + gardian + ", branchId=" + branchId + ", getId()=" + getId() + ", getStRollNo()="
				+ getStRollNo() + ", getStNaame()=" + getStNaame() + ", getStDateofBirth()=" + getStDateofBirth()
				+ ", getStAddres1()=" + getStAddres1() + ", getStAddres2()=" + getStAddres2() + ", getStPhoneNumber()="
				+ getStPhoneNumber() + ", getStMotherName()=" + getStMotherName() + ", getStFatherName()="
				+ getStFatherName() + ", getStGender()=" + getStGender() + ", getStPincode()=" + getStPincode()
				+ ", getStEmergencyContNumber()=" + getStEmergencyContNumber() + ", getGardian()=" + getGardian()
				+ ", getBranchId()=" + getBranchId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
 }
