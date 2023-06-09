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
	
	
}
