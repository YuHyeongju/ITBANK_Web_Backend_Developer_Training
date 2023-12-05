<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex07.jsp</title>
</head>
<body>
	<h1>파라미터를 입력받는 다양한 방법</h1>
	<hr>

	<fieldset>
		<legend>String request.getParameter(String name)</legend>
		<h4>문자열로 name을 전달하여 value를 반환 받는다.</h4>

		<%
		String name = request.getParameter("name"); //이러면 파라미터를 하나씩받아서 불편하다.
		%>
	</fieldset>

	<fieldset>
		<legend>String[] request.getParameterValues(String name)</legend>
		<h4>하나의 이름으로 여러 값을 입력받을 때 사용한다.(checkbox)</h4>
		<form>
			<p>
				<label><input type="checkbox" name="color" value="빨강">빨강</label>
				<label><input type="checkbox" name="color" value="초록">초록</label>
				<label><input type="checkbox" name="color" value="파랑">파랑</label>
			</p>
			<p>
				<input type="submit">
			</p>
		</form>

		<%
		String[] values = request.getParameterValues("color"); // 배열을 반환함.

		out.print("선택한 값: ");

		for (int i = 0; values != null && i < values.length; i++) {
			String value = values[i];
			out.print(value);
			out.print(i != values.length - 1 ? "," : "</p>");
		}
		%>
	</fieldset>

	<fieldset>

		<legend>Map&lt; String, String[]> request.getParameterMap()</legend>
		<h4>변수의 개수 및 값의 개수에 상관없이 모든 값을 받아온다.</h4>
		<%@ page import="java.util.Map"%>

		<%
		Map<String, String[]> paramMap = request.getParameterMap();
		for (String key : paramMap.keySet()) {
			String[] arr = request.getParameterValues(key);
			out.print("<p>" + key + " : ");
			for (int i = 0; arr != null && i < arr.length; i++) {
				String value = arr[i];
				out.print(value);
				out.print(i != arr.length - 1 ? " , " : "</p>");
			}
		}
		//형식이 정해져있지 않기때문에 싸그리 모아서 출력
		%>

	</fieldset>

	<fieldset>
		<legend>특정 이름의 파라미터만 묶어서 받기</legend>
		<h4>받고 싶은 파라미터를 클래스로 묶어서 만들어두면 자동으로 받는 "태그"가 있다.</h4>
		<form>
			<p>
				<input type="text" name="category" placeholder="category">
			</p>
			<p>
				<input type="text" name="storeName" placeholder="storeName">
			</p>
			<p>
				<input type="text" name="menuName" placeholder="menuName">
			</p>
			<p>
				<input type="number" name="menuPrice" placeholder="menuPrice">
			</p>
			<p>
				<input type="submit">
			</p>
			<%--형식이 정해져있다면 형식끼리 모아서 출력 --%>
		</form>

		<jsp:useBean id="ob" class="food.FoodDTO" />
		<%--빈 객체를 기본생성자로 생성(기본생성자가없으면 작동안함) --%>
		<jsp:setProperty property="*" name="ob" /><%-- input name과 필드 이름을 맞추면 자동으로 대입--%>
		<%--jsp 액션태그 --%>
		<ul>
			<li><%=ob.getCategory()%></li>

			<li><%=ob.getStoreName()%></li>
			<%--표현식 --%>


			<li>${ob.menuName}</li>

			<li>${ob.menuPrice}</li>
			<%-- EL 태그 --%>
		</ul>
	</fieldset>



</body>
</html>