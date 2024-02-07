<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day07</title>
<style>
	.flex{
		display: flex;
	}
	.sb{
		display: flex;
		justify-content: space-between;
	}
	.sa{
		display: flex;
		justify-content: space-around;
	
	}
	
</style>
</head>
<body>

<header>
	<h1><a href = "${cpath }" style="text-decoration: none; color: inherit;">day07</a></h1>
	<div id="login" style="height:60px; display:flex; justify-content: right;">
			<c:if test="${!empty login }">
				<p>	<a href="${cpath }/member/info/${login.idx}" style="text-decoration: none; color: red;">${login.username }</a> 님 로그인 중 
					<a href="${cpath }/member/logout"><button>로그아웃</button></a>
				</p>
			
			</c:if>
	</div>
	<nav>
		<ul class="flex sa" style="list-style: none;">
			<li ><a href="${cpath }/member/list" style="text-decoration: none;">회원목록</a></li> <!-- 주소도 계층형으로 구성하는게 좋다.${cpath }/list 별로다 -->
			<li ><a href="${cpath }/member/login" style="text-decoration: none;">로그인</a></li>
			<li><a href="${cpath }/survey/write" style="text-decoration: none;">설문 등록</a></li>
			<li><a href="${cpath }/survey/list" style="text-decoration: none;">설문 참여</a></li>
			<li><a href="${cpath }/result/list" style="text-decoration: none;">설문 결과</a></li>
		</ul>
	
	</nav>

</header>


</body>
</html>