package com.itbank.controller;


import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.component.MailComponent;

@RestController // ajax라서 
@RequestMapping("/ajax")



public class AjaxController {
	
	private Random ran = new Random();
	
	@Autowired private MailComponent mailComponent;
	
	@PostMapping("/sendMail")
	public int sendMail(@RequestBody HashMap<String, String> param, HttpSession session){
		System.out.println("address : " + param);
		int num = ran.nextInt(899999);
		String authNumber = String.format("%06d" , num);
		System.out.println("authNumber : " + authNumber);
		
		
		session.setAttribute("authNumber", authNumber);
		
		session.setMaxInactiveInterval(180); // 세션 유효 시간 3분
		
		
		param.put("subject","인증번호 발송");
		param.put("content",authNumber);
		System.out.println(param);
		
		int row = mailComponent.sendMimeMessage(param);
		
		System.out.println(row != 0 ? "전송 성공": "전송 실패");
		
		return row;
	}
	
	@GetMapping("/authNumber/{InputNumber}")
	public int authNumber(@PathVariable("InputNumber") String InputNumber, HttpSession session) {
		// 만약 세션이 만료되었다면 (180초) autNumber의 값은 null이다.
		// 두개의 문자열의 일치를 비교할 때 A.equal(B) 형태로 비교한다.
		// null 일 가능성이 있는 문자열을 뒤에 배치해서 NullPointerException을 방지한다.
		
		// 만약 세션이 만료되었을때 예외를 발생시켜서 다른 반환값을 전달하려면 exceptionHandler를 사용하거나
		// 혹은 @RestControllerAdvice 클래스를 작성하여 처리할 수도 있다.
		String authNumber = (String) session.getAttribute("authNumber");
		int row = 0;
		if(InputNumber.equals(authNumber)) {
			row = 1;
		}
		
		return row;
	}
}
