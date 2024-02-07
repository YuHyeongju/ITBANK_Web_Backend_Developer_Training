package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

/*이름               널?       유형             
---------------- -------- -------------- 
IDX              NOT NULL NUMBER         
WRITER           NOT NULL VARCHAR2(100)  
IMAGE            NOT NULL VARCHAR2(500)  
ORIGINALFILENAME NOT NULL VARCHAR2(500)  
STOREDFILENAME   NOT NULL VARCHAR2(500)  
CONTENT          NOT NULL VARCHAR2(1000)
*/
public class SurveyDTO {
	private int idx;
	private String title;
	private String writer;
	private String image1;
	private String image2;
	private String content1;
	private String content2;
	private int response1_rate;
	private int response2_rate;
	private int survey_count;
	
	

	private MultipartFile upload0;
	private MultipartFile upload1;
	
	
	
	
	

	public int getSurvey_count() {
		return survey_count;
	}

	public void setSurvey_count(int survey_count) {
		this.survey_count = survey_count;
	}

	public int getResponse1_rate() {
		return response1_rate;
	}

	public void setResponse1_rate(int response1_rate) {
		this.response1_rate = response1_rate;
	}

	public int getResponse2_rate() {
		return response2_rate;
	}

	public void setResponse2_rate(int response2_rate) {
		this.response2_rate = response2_rate;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public MultipartFile getUpload0() {
		return upload0;
	}

	public void setUpload0(MultipartFile upload0) {
		this.upload0 = upload0;
	}

	public MultipartFile getUpload1() {
		return upload1;
	}

	public void setUpload1(MultipartFile upload1) {
		this.upload1 = upload1;
	}

}
