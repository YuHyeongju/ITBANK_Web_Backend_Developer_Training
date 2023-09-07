package com.itbank.model;

import java.sql.Date;

/*
IDX       NOT NULL NUMBER       
BOARD_IDX          NUMBER       
CONTENTS           CLOB         
WRITER             VARCHAR2(20) 
WDATE              DATE 
*/


public class ReplyVO {
	private int idx, board_idx;
	private String contents, writer;
	private Date wdate;
	
	
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
}
