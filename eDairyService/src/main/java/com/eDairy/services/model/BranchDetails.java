package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "BranchDetails")
public class BranchDetails {
	
	@Id
	private String id;
	private String branchId;
	private String branchName;
	private String place;
	private String phoneNumber;
	private String address;
	private String pinNumber;
	
	

}
