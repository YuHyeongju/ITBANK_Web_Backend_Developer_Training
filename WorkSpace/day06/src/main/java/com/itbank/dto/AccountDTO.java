package com.itbank.dto;

public class AccountDTO {
	
	
	public AccountDTO(String id, String pw, String nick) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}
	
	public AccountDTO() {}//기본생성자: 생성자가 없을때 만들어짐
	
	
	private String id;
	private String pw;
	private String nick;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
