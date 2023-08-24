package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Leave")
public class Leave {
	
	
	@Id
	private String id;
	private String LeaveId;
	private String academicYear;
	private String standardId;
	private String branchId;
	private String LeaveReason;
	private String Leaveby;
	private String LeaveType;
	private String LeaveDate;
	private String LeaveEndDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLeaveId() {
		return LeaveId;
	}
	public void setLeaveId(String leaveId) {
		LeaveId = leaveId;
	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
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
	public String getLeaveReason() {
		return LeaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		LeaveReason = leaveReason;
	}
	public String getLeaveby() {
		return Leaveby;
	}
	public void setLeaveby(String leaveby) {
		Leaveby = leaveby;
	}
	public String getLeaveType() {
		return LeaveType;
	}
	public void setLeaveType(String leaveType) {
		LeaveType = leaveType;
	}
	public String getLeaveDate() {
		return LeaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		LeaveDate = leaveDate;
	}
	public String getLeaveEndDate() {
		return LeaveEndDate;
	}
	public void setLeaveEndDate(String leaveEndDate) {
		LeaveEndDate = leaveEndDate;
	}
	@Override
	public String toString() {
		return "Leave [id=" + id + ", LeaveId=" + LeaveId + ", academicYear=" + academicYear + ", standardId="
				+ standardId + ", branchId=" + branchId + ", LeaveReason=" + LeaveReason + ", Leaveby=" + Leaveby
				+ ", LeaveType=" + LeaveType + ", LeaveDate=" + LeaveDate + ", LeaveEndDate=" + LeaveEndDate + "]";
	}
	
	
	
	
	
	

}
