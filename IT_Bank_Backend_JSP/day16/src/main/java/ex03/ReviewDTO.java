package ex03;

import java.sql.Date;

/*
 SQL(DDL)
 
 create sequence review_seq
 	increment by 1
 	start with 1
 	maxvalue 99999
 	nocache
 	nocycle;
 
 
 
 create table review(
 	idx 		number 				default review_seq.nextval primary key,
 	image 		varchar2(500) 		not null,
 	storeName	varchar2(100)		not null,
 	content		varchar2(2000)		not null,
 	visitDate	date				default sysdate(오늘날짜로 한다면) not null(다른 방문날짜로 한다면)
 );
 
  */

public class ReviewDTO {
	
	private int idx;
	private String image;
	private String storeName;
	private String content;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	private Date visitDate;
	
	
	
	
}
