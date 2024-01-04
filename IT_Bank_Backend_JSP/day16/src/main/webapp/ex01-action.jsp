<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01-action.jsp</title>
</head>
<body>
	<h4>ex01-action.jsp</h4>
	<hr>

	<%
	// 사용자가 파일을 첨부하여 제출하는 상황이라면 
	// 첨부파일의 크기를 미리 예측할 수 없다.
	// 큰 용량의 파일을 단일 객체로 전송할 수 없기 때문에, 여러 파트로 분할하여 전송한 후 재조립한다.
	// form-data를 여러 파트로 분할하여 전송하는 방식을 multipart/form-data라고 한다.

	// 양식 데이터 전송시 분할하여 제출하고, 재조립하는 방식을 사용할 수 있기 때문에 
	// 일반적인 request 형식으로는 파라미터 및 파일을 확인할 수 없다.
	// 따라서 특정 라이브러리를 추가하여 사용해야한다.
	// com.oreilly.servlet.MultipartRequest(cos.jar) 다운로드 받아야함.

	request.setCharacterEncoding("UTF-8");

	String method = request.getMethod();
	String test1 = request.getParameter("test1");
	// 폼에서 type=text의 이름을 test1으로 지정하여 전송했기때문에
	%>

	<h3>
		method:
		<%=method%></h3>
	<h3>
		test:
		<%=test1%></h3>

	<%
	// new multipartRequest(request, 저장디렉토리(폴더), 최대전송크기, 글자인코딩, 중복처리정책);
	// 기존의 내장 객체 request와 몇가지 옵션을 추가로 전달받아서, 
	// 파일을 전송받을 수 있는 새로운 형태의 request를 생성하는 라이브러리 클래스 
	MultipartRequest mpRequest = null;

	String saveDirectory = application.getRealPath("/upload"); // 톰캣상에서 업로드라는 이름의 경로를 dir.mkdirs();로 만듦
	int maxPostSize = 1024 * 1024 * 20; //20mb // 사이즈를 초과하면 예외 발생
	String encoding = "UTF-8";
	FileRenamePolicy policy = new DefaultFileRenamePolicy();

	File dir = new File(saveDirectory);
	if (dir.exists() == false) {
		dir.mkdirs();
	}

	mpRequest = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);

	test1 = mpRequest.getParameter("test1");
	File f = mpRequest.getFile("profileImg");
	%>
	<hr>
	<h3>
		test1:
		<%=test1%></h3>
	<h3>
		저장위치:
		<%=saveDirectory%></h3>
	<h3>
		파일이름:
		<%=f.getName()%></h3>
	<h3>
		파일크기:
		<%=f.length()%></h3>
	<div>

		<img src="upload/<%=f.getName()%>" height="150">

	</div>
	<a href="ex01-form.jsp"><button>다시입력</button></a>

</body>
</html>