package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.dto.PersonDTO;
import com.itbank.service.Ex04Service;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	@Autowired      //스프링 컨테이너 에서 아래 클래스와 동일한 객체를 주입
					//스프링아 너가 관리하는 컨테이너에 내가 ex04Service가있으면 줄래? 부탁하는것
					//스프링은 있으면 넣어줌 -> DI (Dependency Injection)
	private Ex04Service es;     
	//원래는 new Ex04Service(); 해야 객체생성  ex) 리모컨-건전지, 자동차-기름
	
	@GetMapping("/test")
	public void ex04() {}
	
	@PostMapping("/test")
	public String ex04(Model model, PersonDTO per) {
		
		String adult = es.isAdult(per);
		
		model.addAttribute("per", per);
		model.addAttribute("adult", adult);
		
		return "ex04/test_result";
	}
}
