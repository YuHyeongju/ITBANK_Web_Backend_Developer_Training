<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

${dao.delete(param.idx)} <%-- 
								param: el태그의 내장객체 
							 	idx가 맞으면 삭제--%>
<%
	response.sendRedirect("list.jsp");

%>