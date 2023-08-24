package com.eDairy.services.model;

import java.util.ArrayList;

public class EDairyStudentStatus {
	
	private String stRollNo;
	private String dairyCompletionStatus;
 	
	private ArrayList<EdairyComments> edairyComments;

	public String getStRollNo() {
		return stRollNo;
	}

	public void setStRollNo(String stRollNo) {
		this.stRollNo = stRollNo;
	}

	public String getDairyCompletionStatus() {
		return dairyCompletionStatus;
	}

	public void setDairyCompletionStatus(String dairyCompletionStatus) {
		this.dairyCompletionStatus = dairyCompletionStatus;
	}

	public ArrayList<EdairyComments> getEdairyComments() {
		return edairyComments;
	}

	public void setEdairyComments(ArrayList<EdairyComments> edairyComments) {
		this.edairyComments = edairyComments;
	}
	
	
	

}
