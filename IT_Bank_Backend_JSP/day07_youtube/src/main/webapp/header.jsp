<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>	
<c:set var="cpath" value="${pageContext.request.contextPath}"></c:set>
<jsp:useBean id="dao" class="youtube.YoutubeDAO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유튜브</title>
<style>
 html{
 	background-color: black;
 	color:white;
 
 }
 .frame {
	width: 900px;
	margin: 0 auto;
	border: 1px dashed red;
} 

.frame>.top {
	display: flex;
	justify-content: space-between;
	width: 900px;
	position: fixed;
	z-index: 1;
	background-color: black;
	top: 0;
}

.frame>.top>.left {
	flex: 1;
	display: flex;
	
}
.frame>.top>.left >.burger{
	font-size: 30px;
	margin: auto auto;
	padding: 10px;
}
.frame>.top>.left >.burger > a{
	text-decoration: none;
	color: white
}
.logo {
	margin: auto auto;
	
}

.frame>.top>.center {
	flex: 5;
	display: flex;
	justify-content: center;
	align-items: center;
}
.frame>.top>.center >.search{
	display:flex;
	justify-content: center;
	align-items: center;
	border: 1px solid grey;
	border-radius: 50px;
	
}
.frame>.top>.center >.search > form > input{
	all:unset;
	flex:6;
	width: 300px;
	height:30px;
	padding-left:10px;
	border-radius: 200px;
	margin: 0;
	border-right: 0;
	
}
.frame>.top>.center >.search > form > button{
	flex:1;
	border-radius: 200px;
	height: 30px;
	margin: 0;
	border-left: 0:
}

.frame>.top>.right {
	flex: 1;
	display: flex;
}
.frame>.top>.right> .login {
	margin: auto auto;
}

.box{
  	display: flex;
  	flex-flow: wrap;
  	margin: auto;
}
.item{
	box-sizing: border-box;
	width:200px;
	margin: 10px;
	padding: 10px;
	text-align:center;
	
}
.frame > .box > .item > .title{
	padding-left: 25px;
	
}
.frame > .box > .item > .name{
	padding-left: 25px;
	
}
.detail{
	display: flex;
	flex-flow: column;
	justify-content: center;
	align-items: center;
	text-align:center;
}
.sb{
	display: flex;
	justify-content: space-between;
	align-items: center;
}
.add{
	display: flex;
	flex-flow: cloumn;
	justify-content: center;
	align-items:center;

}
.modify{
	display: flex;
	flex-flow:column;
	justify-content: center;
	align-items: center;

}
.modify > form > p > textarea{
	width: 200px;
	height: 250px;
	resize: none;
}
 

</style>

</head>
<body>

	<header class="frame">
		<div class="top">
			<div class="left">
				<div class="burger">
					<a href="#">≡</a>
				</div>
				<div class="logo">
					<img
						src="data:image/png;base64,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"
						width=150px height=70px>
				</div>

			</div>


			<div class="center">
				<div class="search">
					<form action="search.jsp">
						<input type="search" name="title" placeholder="검색" value="${param.title }">
						<button>검색</button>
					</form>
						
				</div>
			</div>
			<div class="right">
				<div class="login">
					<button>로그인</button>
				</div>
			</div>
		</div>
		<div class="center"></div>
		<div class="bottom"></div>



	</header>


</body>
</html>