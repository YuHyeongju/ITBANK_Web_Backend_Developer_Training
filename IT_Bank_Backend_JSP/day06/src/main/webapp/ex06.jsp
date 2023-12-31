<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,ex06.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex06.jsp</title>
</head>
<body>
<h1>EL Tag</h1>
<hr>

<h3>expression language</h3>
<h3>기존 표현식에서 attribute 및 parameter 값을 출력할 때 코드가 긴 점을 개선한 형태</h3>


<fieldset>
	<legend>attribute</legend>
	<p>내장객체에 저장된 attribute의 이름을 지정하면 값을 출력한다.</p>
	<p>Object 타입의 객체가 저장되므로, 출력시에는 객체의 toStirng() 결과를 출력한다.</p>
	<p>배열 및 List에는 []형태로 index를 지정할 수 있다.</p>
	<p>자바 빈즈 객체는 .연산자를 이용하여 필드 이름을 지정하면 getter를 호출하여 출력한다.</p>
	<p>Map 형태의 객체는 [''] 안에 key이름을 넣어서 value를 출력한다.

	<%
		String t1 = "Hello world";
		Integer[] arr = {4, 8, 2 ,7 ,6}; 
		List<Integer> list = Arrays.asList(arr);
		HashMap<String, String> map = new HashMap<>();
		map.put("apple","사과");
		map.put("banana","바나나");
		
		TestDTO ob1 = new TestDTO();
		ob1.setName("이지은");
		ob1.setAge(31);
	
		TestDTO ob2 = new TestDTO();
		ob2.setName("홍진호");
		ob2.setAge(42);
		
		ArrayList<TestDTO> arrayList = new ArrayList<>();
		arrayList.add(ob1);
		arrayList.add(ob2);
	
	
		pageContext.setAttribute("t1", t1); // EL Tag를 사용하기위해 어트리뷰트에 t1을 넣어줌
		pageContext.setAttribute("arr", arr);
	%>
	
	<fieldset> 
		<legend>String</legend> <%-- el태그와 표현식에 String을 사용할 때 --%>
		<p>표현식: <%=t1 %></p>
		<p>EL Tag:  ${t1 }</p>
	</fieldset>
	
	<br>
	
	<fieldset>
		<legend>Array</legend>	<%-- el태그와 표현식에 Array를 사용할 때 --%>
		<p>표현식: <%=arr[0] %>,<%=arr[1] %>,<%=arr[2] %>,<%=arr[3] %>,<%=arr[4] %></p>
		<p>EL Tag: ${arr[0] },${arr[1] },${arr[2] },${arr[3] },${arr[4] }</p>
	</fieldset>
	
	<br>
	<% pageContext.setAttribute("list", list); %>
	<fieldset>
		<legend>List</legend>	<%-- el태그와 표현식에 List를 사용할 때 --%>
		<p>표현식: <%=list.get(0) %>,<%=list.get(1) %>,<%=((List<Integer>)pageContext.getAttribute("list")).get(2) %></p>
		<p>EL Tag: ${list[0] },${list[1] },${list[2] }</p>
	</fieldset>
	<%-- EL 태그입장에서 array와 list가 다른 것이 없다. --%>
	
	<br>
	<% pageContext.setAttribute("map", map); %>
	<fieldset>	
		<legend>map</legend>	<%-- el태그와 표현식에 Map을 사용할 때 --%>
		<p>표현식: <%=map.get("apple") %>,
				  <%=((HashMap<String, String>)pageContext.getAttribute("map")).get("banana") %>
		</p>
		<p>EL Tag: ${map.apple },${map['banana'] } </p>
		
		<%-- 배열에서 index는 map의 key와 하는 역할이 같다. --%>
	</fieldset>
	<br>
	<% pageContext.setAttribute("ob1", ob1); %>
	<fieldset>
		<legend>DTO</legend>	<%-- el태그와 표현식에 DTO를 사용할 때 --%>
		<p>표현식: <%=ob1.getName() %>,<%=ob1.getAge() %><br>
			<%=((TestDTO)pageContext.getAttribute("ob1")).getName() %>,
			<%=((TestDTO)pageContext.getAttribute("ob1")).getAge() %>
		</p>
		<p>EL Tag: ${ob1.name },${ob1.age } </p>
		
	</fieldset>
	<br>
	
	<% pageContext.setAttribute("arrayList", arrayList); %>
	<fieldset>
		<legend>List&lt;DTO></legend>	<%-- el태그와 표현식에 DTO객체를 사용할 때 --%>
		<p>표현식: <%=arrayList.get(1).getName() %>,
			<%=((ArrayList<TestDTO>)pageContext.getAttribute("arrayList")).get(1).getAge() %>
		</p>
		<p>EL Tag: ${arrayList[1].name },${arrayList[1].age } </p>
		
	</fieldset>
	<%-- EL태그를 사용하면 attribute에 손쉽게 접근할 수 있다. --%>
	
	<br>
	
	<fieldset>
		<legend>parameter</legend> <%-- el태그와 표현식에 파라미터를 사용할 때 --%>
		<form>
			<input name="name">
		</form>
		<p>표현식: <%=request.getParameter("name") %></p>
		<p>EL Tag: ${param.name } </p>
		
	</fieldset>
	
	
</fieldset>

</body>
</html>