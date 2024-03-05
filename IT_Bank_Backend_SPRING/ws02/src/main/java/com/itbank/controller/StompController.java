package com.itbank.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.itbank.model.MessageDTO;

@Controller
public class StompController {
	
	@MessageMapping("/enter/{roomId}") // 들어오는 주소
	@SendTo("/broker/room/{roomId}")	// 브로커에게 보내는 주소(브로커가 다시 클라이언트에게 보낸다.)
	public MessageDTO enter(MessageDTO message) {
		message.setText(message.getFrom() + "님이 채팅방에 참여하셨습니다.");
		message.setFrom("service");
		return message;
	}
	
	@MessageMapping("/message/{roomId}")
	@SendTo("/broker/room/{roomId}")
	public MessageDTO message(MessageDTO message) {
		return message;
	}
}
// STOMP는 구독이라는 시스템 형태로 그 채팅방 안에 있는 사람은 같은 구독을 하고있다 생각하고 그방에 사람들에게만 채팅을 뿌려준다.