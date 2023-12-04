<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
<style>
	table{
		border-collapse: collapse;
		border: 2px solid black;
		
	}
	td ,th{
		padding: 6px;
		border: 1px solid grey;
	}
	tr > td:nth-child(3){
		color: orangered;
		font-family: Consolas;
		font-weight: bold;
	}
	
</style>
</head>
<body>

<h1>JSP 기본 문법 </h1>
<hr>

<table>
	<thead>
		<tr>
			<th>종류</th>
			<th>역할</th>
			<th>예시</th>
		</tr>
		
	</thead>
	<tbody>
		<tr>
			<td>지시자, directive</td>
			<td>JSP 페이지 전반에 걸쳐 적용되는 설정을 수행한다.</td>
			<td>&lt;%@ page import="java.util.Date" %></td>
		</tr>
		<tr>
			<td>선언부, declaration</td>
			<td>JSP가 클래스로 변환될 때, 멤버 필드 및 멤버 메서드에 해당하는 항목을 작성한다. </td>
			<td>&lt;%! private String str="Hello, world !!"; %></td>
		</tr>
		<tr>
			<td>스크립틀릿, scriptlet</td>
			<td>JSP가 클래스로 변환될 때, doService() 메서드 내부 내용을 작성한다.(main과 유사함.)</td>
			<td>&lt;% list.add("apple"); %></td>
		</tr>
		<tr>
			<td>표현식, expression</td>
			<td>HTML 태그 중간에 JAVA객체의 값을 출력하기위해 사용한다.(out.print()와 동일함)</td>
			<td>&lt;%= str %></td>
		</tr>
	</tbody>
</table>

<!--html 주석: 브라우저에서 소스 코드 보기로 볼 수 있다. -->
<%-- jsp 주석,  브라우저에서 확인할 수 없다. 
	 서버코드가 선 처리되기때문이다
	 applet: 클라이언트에서 돌아감.
	 servlet: 서버에서 작동하기떄문에 클라이언트는 서버에서 무슨 일이 생기는지 알 수 없음.
--%> 

</body>
</html>