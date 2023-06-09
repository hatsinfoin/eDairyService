package com.eDairy.services.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
public class Years {

	@Id
	private String yearId;
	//private String yearDate;
	private List<HolidayLists> holidayLists;
	private List<NoticeBoardDetails> noticeBoardDetails;
	

}
