<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02.jsp</title>
</head>
<body>
<h1>include</h1>
<hr>


<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<th>&lt; %@ include file="" %></th>
		<td>서로 다른 JSP 파일의 소스를 먼저 합치고 컴파일을 수행함. </td>
		<td>지역변수가 서로 공유된다. 변수의 이름을 중복시키면 안된다.</td>
		<%-- 
			파일은 두 개지만 실제로 실행될 때는 하나로 실행됨  
			int a 가 a파일에 있고, int b가 b파일에 있을 때  b=a가 성립한다.
			
		--%>
	</tr>
	<tr>
		<th>&lt;jsp:include page="" /></th>
		<td>각 jsp를 컴파일하고, 결과를 합친다. </td>
		<td>지역변수가 공유되지 않는다. 변수 충돌을 막기 위해 사용할 수 있다.</td>
		<%-- 
			파일이 두 개이고 별개이다. 단지 모양만 합쳐서 출력될 뿐이다.  
			int a 가 a파일에 있고, int b가 b파일에 있을 때  b=a가 성립되지않는다.
			
			이미 만들어진 페이지를 새로운 페이지 내에 포함시키고 싶은데  변수를 공유하지는 
			않을 경우 액션태그 include 사용
		--%>
		
	</tr>


</table>

<h3>자바 소스코드 관점에서 내용을 합치려면 지시자를 사용한다.</h3>
<h3>단순히 결과물의 모양만 합치려면 액션태그를 사용한다.</h3>


</body>
</html>