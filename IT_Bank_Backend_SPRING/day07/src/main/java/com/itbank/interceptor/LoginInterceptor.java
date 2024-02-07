package com.itbank.interceptor;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 스프링 4 에서는 extends HandlerInterceptorAdator
// 스프링 5 에서는 implements HandlerInterceptor
// HandlerInterceptor는 인터페이스지만, 내부 함수가 default 키워드로 처리 되어있음.
// 인터페이스에서 default 함수는 바디를 가질 수 있다.
// 미 구현된 메서드만 구현되면 된다.
// 추상 메서드가 아니라서 모든 메서드를 의무적으로 오버라이딩할 필요가 없음.



public class LoginInterceptor  implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception
	{	// Handle: 컨트롤러의 함수를 의미
		
		// preHandle : 컨트롤러의 함수(handler)에 요청이 전달되기 이전에 요청을 가로채서 작업을 수행
		// 반환값에 따라 예정된 내용을 그대로 처리할지, 다른 내용을 수행할지 결정
		
		// postHandle		: 컨트롤러의 함수(handler)가 종료된 후 view(jsp)로 넘어가는 중에 인터셉터
		
		// afterCompletion	: view(jsp)가 클라이언트에 도달 했을 때(실행됬을때) 인터셉터하여 처리
		
		System.out.println("1.preHandle");
		
		HttpSession session = request.getSession();
		
		
		String url = request.getRequestURL().toString(); // 원래 갈려고 했던 주소를 출력
		System.out.println("url: " + url);
		
		
		if(session.getAttribute("login") == null) {// 만약 세션에 로그인이 없으면
			String cpath = request.getContextPath();
			response.sendRedirect(cpath + "/member/login?url=" + url); // 주소창에 원래 가려고 했던 주소가 출력된다.
			System.out.println("로그인 상태가 아니므로, 로그인 페이지로 이동합니다.");
			return false;	// 진행 중단 true로 해버리면 조건이 안맞아도 게시글이 삭제되는 문제가 생긴다.
		}

		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object Handler, ModelAndView mav) throws Exception {
		// 컨트롤러의 처리가 끝났고 JSP로 넘어가기전에 작동함
		// JSP로 Forword가 이루어지기 전에, request, cookie, session 등에서 필요한 값을 확인하고 판별하여
		// ModelAndView 를 이용하여 특정 데이터를 넘겨주는데 활용가능
		// header.jsp를 사용할 수 있으나, 모든 페이지에 영향을 주기 때문에 적용하기 쉽지않다. 
		System.out.println("2. postHandle");
		mav.addObject("test1", "Hello, InterCeptor");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object Handler, Exception ex) throws Exception {
		// 사용자에게 JSP의 화면이 모두 전달되고, 응답이 완료된 후 작동함.
		// 만약, 예외가 발생했다면, 혹은 예외가 특정 타입의 예외라면 로그에 기록하거나 알림을 처리할 수 있다.(로그를 직접 구성한다면 가능, 라이브러리가 있음.
		//log4J 라이브러리 , @ExceptionHandler, @ControllerAdvice가 예외를 처리하는데 특화 되어있음.) 
		System.out.println("3.afterCompletion");
	}

}
