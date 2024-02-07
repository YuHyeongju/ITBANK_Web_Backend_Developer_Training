package com.itbank.interceptor;

// 인터셉터의 모든 기능을 구현할 수 없기 때문에 만들어진 클래스/ 인터페이스를 상속/구현한다.

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.itbank.model.MemberDTO;


public class AdminInterceptor implements HandlerInterceptor {
	
	// 메뉴를 클릭했을때 로그인 상태에 따라 컨트롤러의 함수를 실행하지 않아야 하므로 preHandler를 사용한다.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
		
		// 조건을 판별하기위해 필요한 값을 가져온다.
		// 로그인 정보는 세션에 있고, request 객체에서 가져올 수 있다.
		
		
		HttpSession  session = request.getSession();
		
		// 세션에 들어있는 로그인 정보는 MemberDTO 타입으로 받을 수 있다.
		// getAttribute() 는  Object 타입을 반환하므로, 좌우 자료형을 맞추기 위해 캐스팅 한다.
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		
		
		// 만약 로그인 객체가 없거나, 로그인 되어 있으나 관리자가 아니면 진행 중단
		if(dto == null || !dto.getUserid().equals("root")) {
			
			//forward 하기전에 필요한 값을 setAttribute에 넣어준다.(mav.addObject와 동일하다)
			 request.setAttribute("msg", "관리자만 접근가능합니다."); 
			 request.setAttribute("url", "/"); 
			 // 여기서 처리를 해서 보내주면 alert.jsp에서 if문을 만들지 않아도 else문으로  처리할 수 있음.
			
			// alert.jsp는 내부 설정 폴더(WEB-INF)에  있으므로 , 리다이렉트로 접근 불가능하다.
			// 따라서 forward로 진행해야한다.
			//forward를 수행하기위해 getRequestDispatcher 객체를 불러온다.
			// forward하기 위해서는 이동할 경로를 설정해야한다.(prefix + viewName + suffix)
			//forward를 수행한다.
			request.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(request,response);
			
			
			
			
			 
			
			
			return false; // 진행 중단
		}
		return true; // 계속 진행
	}
	
}
