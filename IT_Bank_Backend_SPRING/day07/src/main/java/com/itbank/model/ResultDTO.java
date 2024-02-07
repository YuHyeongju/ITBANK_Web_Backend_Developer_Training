package com.itbank.model;

/*이름         널? 유형            
---------- -- ------------- 
USERID        VARCHAR2(100) 
RESPONSE      CHAR(1)       
SURVEY_IDX    NUMBER */

public class ResultDTO {
	private String userid;
	private String response;
	private int survey_idx;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getSurvey_idx() {
		return survey_idx;
	}

	public void setSurvey_idx(int survey_idx) {
		this.survey_idx = survey_idx;
	}

}
