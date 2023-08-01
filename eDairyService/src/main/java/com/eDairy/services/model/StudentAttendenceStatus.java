package com.eDairy.services.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
 public class StudentAttendenceStatus {
	
 	private String stRollNo;
	private String attendanceStatus;
	public String getStRollNo() {
		return stRollNo;
	}
	public void setStRollNo(String stRollNo) {
		this.stRollNo = stRollNo;
	}
	public String getAttendanceStatus() {
		return attendanceStatus;
	}
	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}
	@Override
	public String toString() {
		return "StudentAttendenceStatus [stRollNo=" + stRollNo + ", attendanceStatus=" + attendanceStatus + "]";
	}
  	 
}
