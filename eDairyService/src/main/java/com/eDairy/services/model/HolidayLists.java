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
	@Override
	public String toString() {
		return "HolidayLists [SNo=" + SNo + ", holidayName=" + holidayName + ", holidayDate=" + holidayDate + "]";
	}
}


