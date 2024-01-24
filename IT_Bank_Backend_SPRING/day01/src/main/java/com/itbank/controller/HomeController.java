package com.itbank.controller;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.TestService;


@Controller
public class HomeController {

	@Autowired
	private TestService testService;

	// MVC 패턴에서 JSP를 향한 포워드를 기본으로 사용하기 때문에 
	// 요청 주소와 JSP의 이름은 분리되어 생각해야함.
	// 따라서 JSP파일을 단독으로 실행 불가능하다.
	
	
	@GetMapping("/")				//만약, "/" 경로로 GET 요청을 받으면 
	public ModelAndView home() {	// home 함수를 실행
		ModelAndView mav = new ModelAndView("home");  // 매개변수에 home을 넣어준다.  // viewName을 "home"으로 설정한다.
		//mav.setViewName("home");// 상황에 따라 다른 jsp로 포워딩 안할꺼면 
		
		String version = testService.getDBVersion();
		Date sysdate = testService.getSysDate();
		mav.addObject("sysdate",sysdate);
		mav.addObject("version",version);
		return mav;				 // 반환되면 "/WEB-INF/views/home.jsp"로 포워딩한다.
	}

}
//