package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "HolidayLists")
public class HolidayLists {

	@Id
	private String id;
	private String branchId;
	private String holidayDate;
	private String holidayTitle;
	private String holidayDiscription;
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
	public String getHolidayDate() {
		return holidayDate;
	}
	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}
	public String getHolidayTitle() {
		return holidayTitle;
	}
	public void setHolidayTitle(String holidayTitle) {
		this.holidayTitle = holidayTitle;
	}
	public String getHolidayDiscription() {
		return holidayDiscription;
	}
	public void setHolidayDiscription(String holidayDiscription) {
		this.holidayDiscription = holidayDiscription;
	}
	@Override
	public String toString() {
		return "HolidayLists [id=" + id + ", branchId=" + branchId + ", holidayDate=" + holidayDate + ", holidayTitle="
				+ holidayTitle + ", holidayDiscription=" + holidayDiscription + "]";
	}
 
	
}
