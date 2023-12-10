<%@page import="book.BookDTO"%>
<%@page import="book.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

	BookDAO dao = (BookDAO) application.getAttribute("dao"); // dao라는 이름의 객체를 application에 등록
	int idx = Integer.parseInt(request.getParameter("idx")); //idx라는 파라미터를 가져와 idx에 저장
	BookDTO dto = dao.selectOne(idx);	// selectOne 메서드로 불러온 결과를 dto에 저장
	
	request.setAttribute("dto",dto); //dto를 request에 담아서 
	request.getRequestDispatcher("view-show.jsp").forward(request, response);
	//view-show.jsp로 포워드 
%>