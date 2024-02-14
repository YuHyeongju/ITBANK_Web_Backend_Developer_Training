package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {
	
	
	
	// 일반적인 스프링 컨트롤러 함수는 viewName을 반환해서, JSP로 포워딩하거나 리다이렉트 하는 것이 목적이다.
	@GetMapping("/ex01")
	public void ex01() {}
	
	 
//	// AJAX 요청에 대응하는 컨트롤러 함수는 기본자료형, 배열, 리스트, 맵, DTO 등 여러 타입 반환 가능
//	// 반환 값이 viewName이 아니라 그 자체임을 명시해야함 -> @ResponseBody를 작성해줘야함.
//	@GetMapping("/ex01Ajax") // 다른 자원으로 이동하는 것이 아니라 return 값이 바로 보여지는 형태 
//	@ResponseBody
//	public int ex01Ajax(int n1, int n2) {
//		return n1 + n2;
//	}
}
