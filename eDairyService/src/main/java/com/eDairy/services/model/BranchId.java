package com.eDairy.services.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BranchId {
     private String branchId;
	 private List<DateMonthYear> monthYear;
 	 
}
