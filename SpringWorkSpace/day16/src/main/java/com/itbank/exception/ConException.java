package com.itbank.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//예외를 받아서 처리할 스프링 빈
//- 패키지 단위로 받아서 처리 가능 
@ControllerAdvice("com.itbank.controller")
public class ConException {
	
	@ExceptionHandler(DuplicateKeyException.class)
	public ModelAndView dke() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", 0);
		mav.addObject("msg", "가입 실패. 아이디/닉네임을 확인해 주세요");
		mav.setViewName("msg");
		
		return mav;
	}
}