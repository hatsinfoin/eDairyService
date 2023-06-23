package com.eDairy.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "HolidayLists")
public class HolidayLists {

	@Id
	private String SNo;
	private String holidayName;
	private String holidayDate;

	public String getSNo() {
		return SNo;
	}

	public void setSNo(String sNo) {
		SNo = sNo;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public String getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}

	@Override
	public String toString() {
		return "HolidayLists [SNo=" + SNo + ", holidayName=" + holidayName + ", holidayDate=" + holidayDate + "]";
	}
}
