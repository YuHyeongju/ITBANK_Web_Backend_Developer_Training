<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mcdonald-list.jsp</title>
<style>
.flex {
	display: flex;
}

.wrap {
	display: flex;
	flex-flow: wrap;
}

.sb {
	display: flex;
	justify-content: space-between;
}

.frame {
	width: 900px;
}

section {
	width: 100%;
	height: 100%;
}

.list {
	margin: auto auto;
}

.category {
	width: 150px;
	list-style: none;
	text-decoration: none;
	margin: auto 0;
	margin-right: 15px;
}

#H_img {
	width: 250px;
	height: 200px;
	margin: 10px;
}
</style>
</head>
<body>
	<div class="flex sb">
		<h1>
			<a href="${cpath }" style="text-decoration: none; color: red">맥도날드</a>
		</h1>
		<ul class="category flex sb">
			<li><a href="${cpath }">전체</a></li>
			<li><a href="${cpath }/음료">음료</a></li>
			<li><a href="${cpath }/버거">버거</a></li>

		</ul>
	</div>
	<hr>
	<section>
		<form method="POST">
			<div>
				<div class="flex">
					<a href="${cpath }/add" style="padding-right:10px;"><button>추가</button></a>
					<input type="search" name="search" placeholder="검색하려는 버거 이름을 입력하세요"
						value="${param.search }" style="width: 250px;"> 
					<input type="submit" value="검색">
				</div>
				
				
				<div class="list frame wrap">
					<c:forEach var="dto" items="${list }">
						<div>
							<a href="${cpath}/view/${dto.idx }"><img
								src="${cpath }/resources/image/${dto.imgname}" id="H_img"></a>

							<div style="text-align: center;">${dto.name }</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</form>
	</section>





</body>
</html>