package com.itbank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.controller.Ex02Controller;

/*
 @ControllerAdvice // 예외처리 함수(ExceptionHandler)를 포함하는 클래스
				  // 어노테이션만 작성하면 모든 컨트롤러의 예외를 처리하게 된다.(전역)
*/

// Ex02Controller에서 발생하는 예외만 처리한다.(특정 지역)
@ControllerAdvice(assignableTypes = Ex02Controller.class)
public class Ex02ControllerAdvice {

	@ExceptionHandler(StringEmptyException.class)
	public ModelAndView StringEmpty(StringEmptyException e) {
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("msg", e.getMessage());
		return mav;
	}
	
	@ExceptionHandler(AgeOutOfBoundException.class)
	public ModelAndView AgeOutOfBound(AgeOutOfBoundException e) {
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("msg", e.getMessage());
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView otherException(Exception e) {
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("msg", e.getMessage());
		return mav;
		// 위에서 명시한 예외가 아닌 다른 예외에 대해서도 적절한 처리가 이루어지도록 exception에 대한 내용을 작성한다.
	}
}
