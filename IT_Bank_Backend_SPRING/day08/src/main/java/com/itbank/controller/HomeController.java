package com.itbank.controller;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
//		Date date = new Date();
		Date date = null; // -> nullPointerException 유발 유도
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String sysdate = sdf.format(date);
		mav.addObject("sysdate", sysdate);
//		mav.addObject("date", date);
		return mav;
	}
	@ExceptionHandler(NullPointerException.class)  // 지정한 클래스 타입의 예외가 현재 컨트롤러에서 발생하면 
	public ModelAndView npe() {					// 아래 함수를 실행한다.	(try ~ catch의 함수화)		
		ModelAndView mav = new ModelAndView("home"); // 응답을 전달하는 방식은 @RequestMapping과 유사하다.
		mav.addObject("today", new Date());
		return mav;
		// 현재 컨트롤러 및 컨트롤러 하위의 service, DAO, Component 에서 발생하는 예외를 모두 처리한다.
		// 하위 스프링 빈이 예외를 throws 해야한다.
	}
	
}
/*
 * 보통 예외를 처리하기위해
 * try {
			String sysdate = sdf.format(date);
			mav.addObject("sysdate", sysdate);
		} catch (NullPointerException e) {
			System.out.println("예외가 발생했습네다 : " + e);
		}
 * 
 * 구문을 사용하는데 
 * 코드마다 예외처리를 하려면 코드가 너무 길어진다.
 * 그리고 예외처리하는 코드들이 분산되어 있다.
 * 코드마다 예외 처리를 해야할 상황이 생길텐데 코드마다 try catch 하는건 너무 비 효율적이다.
 * 
 * */
 