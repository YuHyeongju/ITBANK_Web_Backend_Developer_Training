package com.itbank.model;

import java.sql.Date;

/*이름    널?       유형            
----- -------- ------------- 
IDX   NOT NULL NUMBER(38)    
SDATE NOT NULL DATE          
MEMO  NOT NULL VARCHAR2(100) */

public class ScheduleDTO {
	private int idx;
	private Date sDate;
	private String memo;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
