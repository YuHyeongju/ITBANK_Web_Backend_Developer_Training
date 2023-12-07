<%@page import="java.net.URLEncoder"%>
<%@ page import="ex03.UpdownGame"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--Handler (controller) --%>

<%!
	UpdownGame game = new UpdownGame();
%>

<%	// service()
	// 웹 프로그램으로써 수행해야할 전제적인 로직만 나타내고 있다.(request, response)
	// 상세한 기능의 내용은 game 객체 내부에 메서드로 존재한다.
	
	
	// "ture".equals(request.getParameter("reset"))
	if (request.getParameter("reset") != null) {
		game.reset();
		response.sendRedirect("ex03-form.jsp?msg=");  
		return; // 이후 코드 수행 x
	}
	
	String user = request.getParameter("user"); // 유저 입력을 받아서 user에 저장
	String msg = game.handle(user);	// game객체에서 값을 처리후 msg에 저장 

	
	String location = "ex03-form.jsp?msg=" + URLEncoder.encode(msg, "UTF-8");
	
	response.sendRedirect(location);
%>
