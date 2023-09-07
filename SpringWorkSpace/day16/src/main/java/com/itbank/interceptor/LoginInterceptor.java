package com.itbank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.model.AccountVO;

/*
인터셉터 (interceptor)
- 요청을 가로채서 원하는 처리를 할 스프링 빈

작동 시점
1. preHandle		: 컨트롤러에 요청이 전달되기 이전
2. postHandle		: 컨트롤러가 종료된 후
3. afterCompletion	: view가 클라이언트에 도달 했을 때
*/



public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception{
		
		HttpSession session = request.getSession();
		AccountVO user =(AccountVO)session.getAttribute("user");
		
		if( user==null ) {//비로그인상태
			String cpath = request.getContextPath();
			response.sendRedirect(cpath + "/account/login");//로그인창으로 리다이렉트
			
			return false; //false가 반환되면 요청했던 컨트롤러는 실행되지 않음
		}
		
		return true;// true가 반환되면 요청했던 컨트롤러를 이어서 수행

	}

}

