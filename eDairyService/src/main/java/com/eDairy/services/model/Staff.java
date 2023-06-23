package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "Staff")
public class Staff {

	@Id
	private String id;
	private String staffId;
	private String StaffName;
	private String phneNumber;
	
	
	private String staffType;
	private String address;
	private String pinCode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return StaffName;
	}
	public void setStaffName(String staffName) {
		StaffName = staffName;
	}
	public String getPhneNumber() {
		return phneNumber;
	}
	public void setPhneNumber(String phneNumber) {
		this.phneNumber = phneNumber;
	}
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", staffId=" + staffId + ", StaffName=" + StaffName + ", phneNumber=" + phneNumber
				+ ", staffType=" + staffType + ", address=" + address + ", pinCode=" + pinCode + "]";
	}
	
	

}
