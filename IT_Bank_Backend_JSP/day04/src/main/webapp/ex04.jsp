<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex04.jsp</title>
<style>
	table{
		border-collapse: collapse;
		border: 2px solid red;
	}
	tr,td{
		border: 2px solid red;
	}
	th{
		padding: 10px;
	}
	li{
		border: 2px solid grey;
		padding: 10px;
	}
	ul{
		list-style: none;
		padding-left: 0;
		padding: 10px;
	}

</style>
</head>
<body>
	<h1>페이지 이동 기술</h1>
	<hr>


	<h3>redirect:클라이언트에 이동할 주소를 보내주고, 클라이언트가 새로 요청하게 한다.</h3>
	<h3>forward:클라이언트가 요청한 내용을 다른 주소로 념겨서 응답을 보내도록 한다.</h3>

	<table>
		<tr>
			<th>response.sendRedirect(String location)</th>
			<td>
				<ul>
					<li>클라이언트가 새로운 요청을 보내기 때문에, 현재 서버가 아닌 <br>주소도 이동 가능하다.</li>
					<li>클라이언트가 직접 요청을 보내기 때문에, 브라우저 주소창의 <br>주소가 변경된다.</li>
					<li>새로 연결할 전화번호만 알려주고 현재 <br>통화를 끊는 방식</li>
					<li>request, response는 새로 만들어진다.</li>
				</ul>
			</td>
		</tr>
		<tr>
			<th>response.getRequestDispatcher(String uri).forword(request, response)</th>
			<td>
				<ul>
					<li>서버 내부에서 임의로 응답할 주소를 고르지 때문에, 다른 서버로는 넘길 수 없다.</li>
					<li>클라이언트는 관여하지 않고 서버에서 응답을 바꿔치기하므로 브라우저 주소창은 변경되지않는다.</li>
					<li>고객에게 잠시 기다리게 하고, 내선번호로 전화를 돌리는 방식</li>
					<li>request, response가 유지된다.(A에서 setAttribute 하면, B에서 getAttribute 할 수 있다.)</li>
				</ul>
			</td>
		</tr>

	</table>
	
	<fieldset>
		<legend>redirect</legend>
		<form>
			<input type="text" name="redirectURL" placeholder="리다이렉트 주소 입력">
			<button>리다이렉트</button>
		</form>

	</fieldset>
	<fieldset>
		<legend>forward</legend>
		<form>
			<input type="text" name="forwardURI" placeholder="포워드 주소 입력">
			<button>포워드</button>
		</form>

	</fieldset>
	
	<%
		String redirectURL = request.getParameter("redirectURL");
		if(redirectURL != null){
			response.sendRedirect(redirectURL);
			return;
		}
		String forwardURI = request.getParameter("forwordURI");
		if(forwardURI != null){
			request.getRequestDispatcher(forwardURI).forward(request, response);
			// 반환값이 Dispatcher이고 그 Dispatcher에 포워드를 함.
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardURI);
			rd.forward(request, response);
			
		}
	
	
	
	%>

</body>
</html>