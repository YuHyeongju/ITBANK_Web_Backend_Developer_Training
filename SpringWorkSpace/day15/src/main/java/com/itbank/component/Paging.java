package com.itbank.component;


//페이지 상태는 유저마다 별도로 관리가 되어야 함으로 싱글톤이 되면 안된다.
public class Paging {
	private int reqPage; //외부에서 받아옴
	private int perCount = 10;
	private int totalCount;
	private int offset;
	private int perPage = 10; 
	private int totalPage; //외부에서 받아옴
	private int index;
	private	int begin;
	private	int end;
	private boolean next;
	private boolean prev;
	
	public Paging(int reqPage, int totalCount) {
		this.reqPage = reqPage;
		this.totalCount = totalCount;
		
		offset = (reqPage -1) * perCount;
		
		totalPage = totalCount / perCount;
		totalPage += ( totalCount % perCount==0)? 0 : 1;
		
		index = (reqPage - 1) / perPage;
		begin =  index * perPage + 1;
		end = (index + 1) * perPage;
		end = (end > totalPage)? totalPage : end;
		
		next = (end != totalPage);
		prev = (index != 0);
	}

	public int getReqPage() {
		return reqPage;
	}

	public void setReqPage(int reqPage) {
		this.reqPage = reqPage;
	}

	public int getPerCount() {
		return perCount;
	}

	public void setPerCount(int perCount) {
		this.perCount = perCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean getNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean getPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	
	
	
	
	
	
}
