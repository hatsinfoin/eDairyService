package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Subjects")
public class Subjects {
	
	@Id
	private String id;
 	private String subjectsId;
	private String subjectName;
	private String standardId;
	private String branchId;
	
}
