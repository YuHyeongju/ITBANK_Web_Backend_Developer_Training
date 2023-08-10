package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//Spring bean :스프링에서 관리하는 객체
//Spring container: 수프링 빈을 생성하고 관리하는 공간 
//

@Controller // 요청을 처리할 스프링 빈을 등록하는 어노테이션
			// 사용자가 어떤 주소로 요청을 했는가를 받아 처리
			// 적용이 되면 homeCotroller 아이콘에 s가 생김
public class HomeController {
	@GetMapping("/")
	public String home() {

		return "home";
	}

	@GetMapping("/ex01") // void 반환형 : 요청 URL이 viewName이 된다.
	public void ex01() {

	}

	@PostMapping("/ex01")
	public String ex01(HttpServletRequest request) {
		int name = Integer.parseInt(request.getParameter("name"));
		int age = Integer.parseInt(request.getParameter("age"));

		String adult = (age > 20) ? "성인" : "미성년자 ";

		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("result", adult);

		return "ex01_result";
	}

}
