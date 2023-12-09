<%@page import="java.util.ArrayList"%>
<%@page import="person.PersonDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// 리스트를 attribute에 넣어두고 대상을 참조하면서 데이터를 저장
	List<PersonDTO> list = (List<PersonDTO>) application.getAttribute("personList");
	
	if (list == null) { // 리스트가 비었으면
		list = new ArrayList<>(); // 리스트 객체를 만들어서 
		application.setAttribute("personList", list); // 애플리케이션에 personList라는 이름으로 저장한다.
	}
	
	request.setAttribute("list", list);
	request.getRequestDispatcher("list-show.jsp").forward(request, response);
	// getRequestDispatcher: 인자값으로 이동할 페이지의 경로를 지정
	// forward 메서드는 현재페이지에서 사용하던  request, response를 list-show에게 
	// 넘겨줌.
%>