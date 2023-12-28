<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01-action.jsp</title>
<style>
	table{
		border: 1px solid black;
		border-collapse: collapse;
		
	}
	th, td{
		border: 1px solid black;
		padding: 10px;
		text-align: center;
	}

</style>
</head>
<body>

<h1>ex01-action.jsp</h1>
<hr>


<%	
	// GET은 주소창을 통해서 전달하기 때문에 인코딩을 별도로 설정하지 않아도 글자깨짐 현상이 없다.
	// POST는 주소창을 통하지 않아서 별도의 인코딩 형식을 지정해야 글자를 정상적으로 받을 수 있음.
	// 파라미터는 request객체에 담겨서 넘어오기 때문에 request의 인코딩 규칙을 지정한 후 파라미터를 꺼낸다.
	
	request.setCharacterEncoding("UTF-8");// 파라미터를 꺼내오기 전에 인코딩을 해야함.

	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	
	String encoding = request.getCharacterEncoding();
	
	
	
	
	
%>
<h3>userid : <%=userid %></h3>				<%--Query : 질의 --%>
<h3>userpw : <%=userpw %></h3>				<%-- GET: 모든 결과 --%>
<h3>encoding: <%=encoding %></h3>			<%-- GET(?=아이유): 아이유에 관련된 결과를 보고싶다. --%>
											<%-- POST: 봉투에 담아서 보낸다. 받는게 목적이 아님
												get: 클라이언트가 데이터를 받는 것.
												post: 클라이언트가 데이터를 만들어서 서버에게 보내는 것  
											 --%>
<table>
	<thead>
	<tr>
		<th>request method</th>
		<th>parameter</th>
		<th>SQL</th>
	</tr>
	</thead>
	<tbody>
		<tr>
			<td>GET</td>
			<td>-</td>
			<td>select * from ...</td>
		</tr>
		<tr>
			<td>GET</td>
			<td>queryString</td>
			<td>
			
			select * from ... where id ={queryString }<br>
			delete  from ... where id ={queryString }
			
			</td>
		</tr>
		<tr>
			<td>POST</td>
			<td>form-data</td>
			<td>
				insert into ... values({form-data })<br>
				update ... set column = {form-data}<br>
			</td>
		</tr>
		
	</tbody>

</table>											 
											 
											 
											 
											 
											 
											 
											 
											 
											 
</body>
</html>