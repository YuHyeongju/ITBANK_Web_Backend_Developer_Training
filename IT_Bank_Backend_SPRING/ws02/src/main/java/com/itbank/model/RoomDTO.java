package com.itbank.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

// 채팅방
public class RoomDTO {

	private String roomId;
	private String name;
	private Set<WebSocketSession> sessions = new HashSet<>();
	// 웹소켓세션을 저장, 중복을 허용하지 않음. for문으로 순회 가능함.

	// 자바 빈즈 DTO는 기본 생성자만 가지는 것이 좋다.
	public static RoomDTO create(String name) {
		RoomDTO room = new RoomDTO();
		room.roomId = UUID.randomUUID().toString().substring(0, 8);  
		// 채팅방의 ID를 랜덤으로 셍성해서 문자열로 변환후 8글자까지 자르기
		room.name = name;
		return room;
	}

	@Override
	public String toString() {
		String form = "%s] %s\n%s"; // 채팅방 ID, 방 이름, 세션에 들어와 있는 구성원 
		return String.format(form, roomId, name, sessions);
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<WebSocketSession> getSessions() {
		return sessions;
	}

	public void setSessions(Set<WebSocketSession> sessions) {
		this.sessions = sessions;
	}

}
