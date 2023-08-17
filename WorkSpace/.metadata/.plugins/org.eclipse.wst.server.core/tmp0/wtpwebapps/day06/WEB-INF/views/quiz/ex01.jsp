<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h3>Quiz</h3>
	
	<form method= "post">
	
		<p><input name="id" type="text" placeholder ="아이디" required></p>
		<p><input name="pw" type="password" placeholder ="비밀번호" required></p>
		<button>로그인</button>
		
	</form>	
	
	
<%--  
		ex01.jsp : id/pw를 입력 받을 form을 작성
					단, qction 은 작성하지 않고 method는 POST
					
		QuizController: /quiz/ 아래로 오는 요청을 받아서 처리할 클래스
						Get인 경우: ex01.jsp 포워드
						POST인 경우: ex01_result.jsp로 포워드
						-QuizService로 전달받은 id /pw 를 전송
						-그 후 Attribute 를 추가 후 지정 페이지로 포워드 
						
		AccountDTO:  id, pw, nick을 가지는 클래스 
		
		QuizSerivce :  AccountDTO로 계정을 3개정도 생성 
						그 후 전달받은 id , pw 와 일치하는 계정이 있으면 
						그 계정의 정보를 반환
		ex01_result.jsp:  화면에 '닉네임님 로그인 성공을 출력
						만약 일치하는 계정이 없으면 '로그인 실패 '출력											

 --%>	
	
</body>
</html>