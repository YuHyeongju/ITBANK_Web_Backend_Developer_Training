<%@page import="person.PersonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ArrayList<PersonDTO> personList = (ArrayList<PersonDTO>) application.getAttribute("personList"); 
	// PersonDTO타입의 배열리스트를 애플리케이션에 추가
	
	PersonDTO data = null;	// data : 빈 상태
	String name = request.getParameter("name");	// name이라는 이름의 파라미터 요청
	
	for(PersonDTO dto : personList){
		if(dto.getName().equals(name)){	// 파라미터와 이름이 같으면 data에 dto추가
			data  = dto;
			break;
		}
		
	}
	request.setAttribute("dto", data); // data를 dto라는 이름으로 저장
	request.getRequestDispatcher("view-show.jsp").forward(request, response);
	// view-show.jsp로 포워드 request, response 객체를 넘겨줌

%>

