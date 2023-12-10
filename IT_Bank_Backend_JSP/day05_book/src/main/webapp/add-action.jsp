<%@page import="book.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dto" class="book.BookDTO" scope="page"/>
<%--dto라는 이름의 객체를 생성함. 범위는 페이지 --%>
<jsp:setProperty property="*" name="dto"/>
<%-- dto안에 멤버필드랑 파라미터들을 담음--%>

 ${dao.insert(dto) } <%--  dto에 insert메서드로 추가 --%>

<%

	//respose.sendRedirect("list.jsp"); // 전체목록으로 리다이렉트
	
	int lastIdx = BookDTO.getSeq();		// 시퀀스 메서드를 가져와서 lastIdx에 저장
	response.sendRedirect("view.jsp?idx=" + lastIdx);	
	// view.jsp에 마지막 인덱스를 넘겨줌



%>