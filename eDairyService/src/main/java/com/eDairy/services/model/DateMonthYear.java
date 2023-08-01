package com.eDairy.services.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
 public class DateMonthYear {	
	
	private String year;
	private String month;
	private String day; 
	private String dateMonthYear;
	private StandardId standardId;

	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDateMonthYear() {
		return dateMonthYear;
	}
	public void setDateMonthYear(String dateMonthYear) {
		this.dateMonthYear = dateMonthYear;
	}
	public StandardId getStandardId() {
		return standardId;
	}
	public void setStandardId(StandardId standardId) {
		this.standardId = standardId;
	}
	@Override
	public String toString() {
		return "DateMonthYear [dateMonthYear=" + dateMonthYear + ", standardId=" + standardId + "]";
	}
	
 	 
}
