package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Standard")
public class Standard {
	
	@Id
	private String id;
	private String standardId;
 	private String standardName;
	 	private String branchId;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getStandardId() {
			return standardId;
		}
		public void setStandardId(String standardId) {
			this.standardId = standardId;
		}
		public String getStandardName() {
			return standardName;
		}
		public void setStandardName(String standardName) {
			this.standardName = standardName;
		}
		public String getBranchId() {
			return branchId;
		}
		public void setBranchId(String branchId) {
			this.branchId = branchId;
		}
		@Override
		public String toString() {
			return "Standard [id=" + id + ", standardId=" + standardId + ", standardName=" + standardName
					+ ", branchId=" + branchId + "]";
		}
	
	
	

}
