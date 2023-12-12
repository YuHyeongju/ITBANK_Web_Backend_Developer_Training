<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
</head>
<body>
<h1>EL Tag연산자</h1>
<hr>

<h3>EL Tag 에서는 + 연산이 오직 숫자형태로만 처리된다.(문자열은 더하기가 불가능)</h3>
<h3>EL Tag 에서는 값이 null 이면 출력하지 않는다.</h3>
<h3>EL tag에서는 null 여부를 체크하기 위해 empty 연산을 이용한다.</h3>
	
	<c:set var="s1" value="123"/>
	<c:set var="s2" value="11"/>
	
	<%=pageContext.getAttribute("s1").getClass().getSimpleName() %>
	
	<c:set var="s3" value="Hello"/>
	<c:set var="s4" value="World"/>
	<p>${s3 }${s4 }</p> <%-- 연속해서 작성해주면 된다. --%>
	

<table border="1" cellpadding="10" cellspacing="0">
	<tr>
	
		<th colspan="2">산술연산</th>
	
	</tr>

	<tr>
		<td>\${s1 + s2 }</td> <%-- 연산을 할 때 문자열을 넣으면 안된다. --%>
		<%-- \은 EL 자체를 화면에 보여주고싶을때 사용함. --%>
		<td>${s1 + s2 }</td>
	
	</tr>
	<tr>
		<td>\${s1 - s2 }</td> 
		<td>${s1 - s2 }</td>
	
	</tr>
	<tr>
		<td>\${s1 * s2 }</td> 
		<td>${s1 * s2 }</td>
	
	</tr>
	<tr>
		<td>\${s1 / s2 }</td> 
		<td>${s1 / s2 }<br>
		${Integer.valueOf(s1 / s2) }</td> <%-- 그냥 쓰면 소수점까지 계산해버린다. --%>
	
	</tr>
	<tr>
		<td>\${s1 % s2 }</td> 
		<td>
		${s1 % s2 }<br>
		${s1 mod s2 } <%-- el태그안에는 mod연산자가 존재 -> 나머지연산 --%>
		</td>
	
	</tr>
	<tr>
		<th colspan="2">비교 연산</th> 
	</tr>
	<tr>
	
		<td>\${s1 > s2 }<br>
			\${s1 gt s2 }
			<%-- greater than --%>
			
		</td>
		<td>
			${s1 > s2 }<br>
			${s1 gt s2 }
		</td>
	</tr>
	<tr>
		<td>
			\${s1 >= s2 }<br>
			\${s1 ge s2 }
			<%-- great equal --%>
		</td>
		<td>
			${s1 >= s2 }<br>
			${s1 ge s2 }
		</td>
	</tr>
	<tr>
		<td>
			\${s1 < s2 }<br>
			\${s1 lt s2 }
			<%-- less than --%>
		</td>
		<td>
			${s1 < s2 }<br>
			${s1 lt s2 }
		</td>
	</tr>
	<tr>
		<td>
			\${s1 <= s2 }<br>
			\${s1 le s2 }
			<%-- less equal --%>
		</td>
		<td>
			${s1 <= s2 }<br>
			${s1 le s2 }
		</td>
	</tr>
	<tr>
		<td>
			\${s1 == s2 }<br>
			\${s1 eq s2 }
			<%-- equal --%>
		</td>
		<td>
			${s1 == s2 }<br>
			${s1 eq s2 }
		</td>
	</tr>
	<tr>
		<td>
			\${s1 != s2 }<br>
			\${s1 ne s2 }
			<%-- equal --%>
		</td>
		<td>
			${s1 != s2 }<br>
			${s1 ne s2 }
		</td>
	</tr>
	<tr>
		<th colspan="2"> 논리연산자</th>
	</tr>
	<tr>
		<td>
			\${true and true }<br>
			\${true && true }
			
		</td>
		<td>
			${true and true }<br>
			${true && true }
		</td>
	</tr>
	<tr>
		<td>
			\${true or false }<br>
			\${true || false }
		</td>
		<td>
			${true or false }<br>
			${true || false }
		</td>
	</tr>
	<tr>
		<td>
			\${not true }<br>
			\${!true }
			
		</td>
		<td>
			${not true }<br>
			${!true }
		</td>
	</tr>
	<tr>
		<th colspan="2">null 체크</th> 
	</tr>
	<tr>
		<td>
			\${empty param.name }
			\${not empty param.name }
		</td>
		<td>
			${empty param.name }<br>
			${not empty param.name }
		</td>
		<%-- null 체크에 null이 사용되지않음 --%>
	</tr>
	<tr>
	
		<th colspan="2">삼항연산자</th>
	
	</tr>
	<tr>
		<td>
			\${empty sessionScope.login? '로그인' : '로그아웃' }
		</td>
		<td>
			<button>${empty sessionScope.login? '로그인' : '로그아웃' }</button>
		</td>
	
	</tr>
</table>
<h4>${not empty s1 and s1 >= 20 }</h4>
<br>

<h4>표현식 = <%=request.getParameter("test") %></h4>
<h4>EL Tag: ${param.test }</h4> <%-- 반환형이 object타입이기때문에 null값이 들어가있으면 출력을 안한다. --%>

<h4>\${test2.hello() }: ${test2.hello() }</h4> <%-- 자바에서는 .앞에 null이오면 규칙을 어기는것이나
                                                    el tag에서는 에외를 만들어 주지 않는다.
                                                    객체는 있으나 메서드가 없으면 예외 출력
																 --%>



</body>
</html>