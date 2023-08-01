package com.eDairy.services.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
 public class StandardId {	
	
	private String standardId;
	private List<StudentAttendenceStatus> stAttendenceStatus;
	public String getStandardId() {
		return standardId;
	}
	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}
	public List<StudentAttendenceStatus> getStAttendenceStatus() {
		return stAttendenceStatus;
	}
	public void setStAttendenceStatus(List<StudentAttendenceStatus> stAttendenceStatus) {
		this.stAttendenceStatus = stAttendenceStatus;
	}
	@Override
	public String toString() {
		return "StandardId [standardId=" + standardId + ", stAttendenceStatus=" + stAttendenceStatus + "]";
	}
	
 	 
}
