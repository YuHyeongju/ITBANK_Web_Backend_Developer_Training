package com.itbank.test1;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // 해당 클래스가 웹 애플리케이션의 컨트롤러임을 명시함.
		     // 스프링 컨테이너는 이 어노테이션을 보고 빈으로 등록하고, 요청을 컨트롤러에 매핑하여 처리함.
public class HomeController{
	
		// 스프링의 컨트롤러는 자바 서블릿과 달리, 상속을 사용하지 않기 떄문에
		// 보다 자유롭게 함수의 형식을 지정할 수 있음.
	
		@RequestMapping("/") // 들어온 요청을 특정 메서드와 매핑하기 위해 사용
		public String home(HttpServletRequest request) {
			request.setAttribute("msg","Hello, Spring !!"); // 문자열 , 객체를 jsp에 넘길 수 있음.
			return "home";
		}
		int n1;
		int n2;
		
		@GetMapping("/ex01") // home.jsp에서 ex01을 누를 때 요청이 여기로 온다.
		public String ex01(Model model) {
			Random ran = new Random();
			n1  = ran.nextInt(10) + 1;
			n2  = ran.nextInt(10) + 1;
			model.addAttribute("n1",n1);  //request.setAttribute()와 동일함.
			model.addAttribute("n2" ,n2);  //request에는 너무 많은 정보가 포함되어 있음.(무거움)
			return "ex01";
		}
		@PostMapping("/ex01") // ex01에서 처리한 결과를 ex01-result.jsp로 포워드 한다.
		public String ex01(int input, Model model) { 
			// 파라미터는 매개변수에 넣으면 알아서 형 변환까지 처리 해준다.
			// 자바 빈즈 규약을 만족하는 DTO도 처리가능(useBean + setProperty)
			//System.out.println(n1 + n2 == input);
			String exp = String.format("%d + %d  = %d",n1 ,n2, input);
			String color = n1 + n2  == input ? "blue":"red";
			model.addAttribute("exp", exp);
			model.addAttribute("color", color);
			
			return "ex01-result";
		}
		
}
