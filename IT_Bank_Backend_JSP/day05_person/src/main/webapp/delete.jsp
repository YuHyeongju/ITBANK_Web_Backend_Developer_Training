<%@page import="person.PersonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	ArrayList<PersonDTO> personList = (ArrayList<PersonDTO>) application.getAttribute("personList");
	String name = request.getParameter("name");
	
	personList.removeIf(dto -> dto.getName().equals(name));
	// 선택한 이름과  dto의 이름이 같으면 삭제(이름이 중복되면 중복된 이름의 객체 모두 삭제)
	response.sendRedirect("list.jsp");// 리다이렉트

%>