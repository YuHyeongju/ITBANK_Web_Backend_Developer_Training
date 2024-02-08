package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.exception.AgeOutOfBoundException;
import com.itbank.exception.StringEmptyException;

@Controller
@RequestMapping("/ex02")
public class Ex02Controller {
	@GetMapping
	public void ex02() {};
	
	@PostMapping
	public ModelAndView ex02(String name, int age) throws StringEmptyException, AgeOutOfBoundException {
		if("".equals(name)) {
			throw new StringEmptyException();		
			}
		// age의 값이 0보다 작거나, 100을 초과하는 경우 예외를 발생시켜 ControllerAdvice에서 처리
		// 예외클래스의 이름은 AgeOutOfBoundException 입니다.
		// "나이의 값이 범위를 초과합니다."
		if(age < 0 || age > 100) {
			throw new AgeOutOfBoundException();
		}
		ModelAndView mav = new ModelAndView("ex02-result");
		System.out.printf("name : [%s]\n",name); // 공백인지 아닌지 확인 할려고 
		mav.addObject("name", name);
		mav.addObject("age", age);
		mav.addObject("adult", age >= 20? "성인":"미성년자");
		
		return mav;
	}
}
