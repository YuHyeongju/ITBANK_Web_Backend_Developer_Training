<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03-advertist.jsp</title>
<style>
	.root{
		width:100%;
		margin: 0 auto;
		text-align: center;
	}
	.sb{
		display: flex;
		justify-content: space-between;
	}
</style>

</head>
<body>
<div class="root">
	<img src="https://i.namu.wiki/i/L_8IIbFA7ytVpD27_EBCF-aIZpVCn8ZARliLdvX_3UgzQp8LSo39D9gn3unDJDyaC2ft_wtMnkvizNbet9NwzA.svg"
	height="200">
	<h3>람보르기니 팝니다.</h3>
	
	<form action="ex03-close.jsp">
	<div class="sb">
		<div>
			<label>
				<input type="checkbox" name="makeCookie">
				30초간 광고를 표시하지 않습니다.
			</label>
		
		</div>
		<div>
			<input type="submit" value="닫기">
		</div>
	
	
	</div>
			
	</form>
</div>
</body>
</html>