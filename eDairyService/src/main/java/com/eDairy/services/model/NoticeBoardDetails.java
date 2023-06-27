package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="NoticeBoardDetails")
public class NoticeBoardDetails {
	
	@Id
	private String id;
	private String branchId;
	private String noticeDepartment;
	private String noticeTitle;
	private String noticeDetails;
	private String noticeBy;
	private String noticeStartDate;
	private String noticeEndDate;
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
	public String getNoticeDepartment() {
		return noticeDepartment;
	}
	public void setNoticeDepartment(String noticeDepartment) {
		this.noticeDepartment = noticeDepartment;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeDetails() {
		return noticeDetails;
	}
	public void setNoticeDetails(String noticeDetails) {
		this.noticeDetails = noticeDetails;
	}
	public String getNoticeBy() {
		return noticeBy;
	}
	public void setNoticeBy(String noticeBy) {
		this.noticeBy = noticeBy;
	}
	public String getNoticeStartDate() {
		return noticeStartDate;
	}
	public void setNoticeStartDate(String noticeStartDate) {
		this.noticeStartDate = noticeStartDate;
	}
	public String getNoticeEndDate() {
		return noticeEndDate;
	}
	public void setNoticeEndDate(String noticeEndDate) {
		this.noticeEndDate = noticeEndDate;
	}
	@Override
	public String toString() {
		return "NoticeBoardDetails [id=" + id + ", branchId=" + branchId + ", noticeDepartment=" + noticeDepartment
				+ ", noticeTitle=" + noticeTitle + ", noticeDetails=" + noticeDetails + ", noticeBy=" + noticeBy
				+ ", noticeStartDate=" + noticeStartDate + ", noticeEndDate=" + noticeEndDate + "]";
	}
	 
	
}
