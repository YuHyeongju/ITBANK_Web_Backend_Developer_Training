<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>day09</h1>
<hr>
<h3>json: JAVAScript Object Notation</h3>
<h3>자바스크립트에서 객체를 표현하는데 사용하는 문법</h3>

<fieldset>
	<legend>XML</legend>
	<pre>
		&lt;person>
			&lt;name>이지은&lt;/name>
			&lt;age>31&lt/age>
		&lt;/person>		
	</pre>


</fieldset>

<fieldset>
	<legend>JSON</legend>
	<pre>
		{
			"person" : {
				"name" : "이지은",
				"age" : 31,
			}
		}		
	</pre>
	<!-- 마무리 태그가 없어지고 중괄호를 사용하여 범위를 표현함 -->
	<!-- 다른 서비스와의 연결을 위해 표준에 가까운 일치된 데이터 포맷이 필요한데  이것이 XML, JSON인데 비중은 JSON이 높다. -->
	<!-- 
		직렬화: 자바에서 사용되는 Object나 data를 다른 시스템에서도 사용할 수 있도록 byte 배열의 형태로 전송
		역직렬화: 직렬화의 반대 개념 
	-->
</fieldset>



<ul>
	<li><a href="ex01">ex01 - 부산 축제 정보 서비스 연습</a></li>
	<li><a href="ex02">ex02 - 부산 축제 정보 서비스 (AJAX)</a></li>

</ul>




<script>
	// 변수 선언 키워드(자료형이 아니다.)
	t0 = 'Hello'   // 선언은 가능하나 사용하지말라
	var t1 = 'A'   // 문자열, 숫자 상관없이 들어간다.
	let t2 = 15
	const t3 =3.2
	
	// var는 함수 밖에서 재선언 및 재할당가능 -> 왠만하면 사용하지말라는 이유
	// 변수 이름을 중복해서 사용하지 않는다면 이론적으로 큰 문제는 없음
	// 옛날에 작성한 코드에서는 var로 선언한 코드가 있을 수 있음.
	
	console.log(t1)
	console.log(t2)
	console.log(t3)

	
	if(t2 > 10){
		var t1 = 'apple'
	}
	console.log(t1) // 기존의 값에 새 값을 덮어 씌워 버림
	// 프로그래머가 의도하지 않은 결과가 생길 가능성 높음
	// let: 재할당 가능
	// const: 재할당 불가(상수화된 변수, 메모리 효율이 높다.)
	
	// 자료형 확인
	console.log(typeof(t1)) // String
	console.log(typeof(t2)) // number
	console.log(typeof(t3)) // number
	console.log(typeof([])) // object(array)
	console.log(typeof({})) // object
	console.log(typeof(function(){})) // function, JS에서는 함수도 자료형이며 변수에 대입할 수 있다.
									  // 자바에서는 이 개념을 구현할수 있도록 함수형 인터페이스를 사용한다.(람다식)
	
	const t4 = { // Map<String, Object>
			"name" : "이지은",
			"age" : 31
			
			
	}
	console.log(t4)
	console.log(t4.name)
	console.log(t4.age)
	
	const t5 = {    // 자바스크립트 문버에서는 간략하게 나타낼 수도 있다.
					// 단, JSON 문법으로 나타내기 위해서는 key를 ""로 묶어야한다.
			
			name: '홍진호',  // 필드는 어자피 문자 들어오는거 아니까 "" 생략 
			age: 41,
			show: function(){
				console.log(this.name + '님은' + this.age +'살 입니다.')
				// 함수를 변수에 대입
			}
			
	}
	console.log(t5)
	console.log(t5.name)
	console.log(t5.age)
	t5.show
	
	// 자바스크립트에서는 객체를 JSON문법의 문자열로 변환하는 함수 및 되돌리는 함수가 내장되어있음.
	const t6 = JSON.stringify(t4) // 객체를 JSON 문자열로 변환하는 함수
	const t7 = JSON.parse(t6)	  // JSON 문자열을 객체로 변환하는 함수
	
	console.log(t6, typeof(t6))
	console.log(t7, typeof(t7))
</script>
</body>
</html>