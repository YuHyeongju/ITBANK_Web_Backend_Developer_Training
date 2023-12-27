<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02.jsp</title>
<style>
	.white{
		background-color: white;
		color:black;
	}
	.black{
		background-color: black;
		color:#dadada; 
	}
	.lime{
		background-color: black; 
		color:#00FF00;
	}
	.aqua{
		background-color:black;
		color:#00FFFF;
	}
	.orange{
		background-color: black;
		color:orange;
	}
	pre{
		font-size: 16px;
	}
</style>
</head>
<body class="${cookie.theme.value }"> <!-- if문을 넣지않아도 자동으로 넣어짐 -->

<h1>쿠키를 활용한 색상 테마 설정</h1>
<hr>
	<form action="ex02-action.jsp">
		<select name="theme">
			<option ${cookie.theme.value == 'white'? 'selected': '' }>white</option>
			<option ${cookie.theme.value == 'black'? 'selected': '' }>black</option>
			<option ${cookie.theme.value == 'lime'? 'selected': '' }>lime</option>
			<option ${cookie.theme.value == 'aqua'? 'selected': '' }>aqua</option>
			<option ${cookie.theme.value == 'orange'? 'selected': '' }>orange</option>
		</select>
         <input type="submit"> 	
	</form>
	<fieldset>
	
		<legend>lorem</legend>
		<pre>〈서울의 봄〉은 드라마 제5공화국 이후 18년 만이자 영화로는 최초로 12.12 군사반란을 극화화 하는 프로젝트다. 따라서 역사적 사건을 어떻게 스크린에 담아낼지 큰 관심이 모아졌다. 정치적 민감성을 엔터테이너로서 김성수와 제작사 플러스엠이 어떻게 극복할지도 관전 포인트다. 12.12 쿠데타의 두 주역인 전두환과 노태우는 개봉 2년 전 한 달 간격으로 사망했지만 여전히 장세동이나 허화평, 정호용, 박희도 등 신군부 시절의 인사들이 아직 살아 있고, 이들을 지지하는 세력도 건재해 역사적▪︎정치적 이슈와 충돌이 불가피한 상황이기 때문이다. [1]

예를 들어, 전두환을 긍정적으로 그리든 비판적으로 그리든 어느 진영에서고 비난은 날아올 수밖에 없는 형국이다. 게다가 제5공화국의 경우처럼 제작진이 비판하는 입장에서 제작한다 해도 일부 예민한 관객들은 주연 배우의 연기와 외모와 연기만으로 특정 인물을 미화한다고 주장한 전적이 있는 등 여러모로 리스크가 산재한 제작환경이다.[2]
		</pre>
	</fieldset>
	
	
<fieldset>

<div>
	<button id="checkCookie">쿠키 확인</button>
</div>
	
	<script>
		checkCookie.onclick = function(){
			alert(document.cookie)
		}
	</script>
</fieldset>	
	
	
	
</body>
</html>