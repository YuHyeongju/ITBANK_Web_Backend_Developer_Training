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
	private Ex04Service es;    //이를 DI라고 한다. (Dependency Injection)
	
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
