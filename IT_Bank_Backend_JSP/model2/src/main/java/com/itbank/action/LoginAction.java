package com.itbank.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbank.member.MemberDAO;
import com.itbank.member.MemberDTO;

public class LoginAction implements CommandAction{
	
	private MemberDAO memberDAO = MemberDAO.getInstance();

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		return "login";
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		MemberDTO dto = new MemberDTO();
		dto.setUserid(userid);
		dto.setUserpw(userpw);
		
		MemberDTO login = memberDAO.login(dto);

		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		return "redirect:/";
	}
	
}
// 데이터를 불러오고 어떻게 처리할 것인가만 집중하여 개발할 수 있음.(보여지는 것은 jsp에서 처리함)
