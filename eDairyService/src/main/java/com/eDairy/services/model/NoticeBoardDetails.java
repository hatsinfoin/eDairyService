package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="NoticeBoardDetails")
public class NoticeBoardDetails {
	
	@Id
	private String noticeId;
	private String noticeDepartment;
	private String noticeBy;
	private String noticeDetails;
	private String noticeStartDate;
	private String noticeEndDate;
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeDepartment() {
		return noticeDepartment;
	}
	public void setNoticeDepartment(String noticeDepartment) {
		this.noticeDepartment = noticeDepartment;
	}
	public String getNoticeBy() {
		return noticeBy;
	}
	public void setNoticeBy(String noticeBy) {
		this.noticeBy = noticeBy;
	}
	public String getNoticeDetails() {
		return noticeDetails;
	}
	public void setNoticeDetails(String noticeDetails) {
		this.noticeDetails = noticeDetails;
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
		return "NoticeBoardDetails [noticeId=" + noticeId + ", noticeDepartment=" + noticeDepartment + ", noticeBy="
				+ noticeBy + ", noticeDetails=" + noticeDetails + ", noticeStartDate=" + noticeStartDate
				+ ", noticeEndDate=" + noticeEndDate + "]";
	}
	
	
}
