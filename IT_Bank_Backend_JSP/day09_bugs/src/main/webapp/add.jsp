<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add.jsp</title>
<style>
.box {
	border: 1px solid red;
	width: 600px;
	margin: 0 auto;
}
p{
	padding: 10px;
}
</style>
</head>
<body>
	<h4>추가</h4>
	<hr>

	<form action="add-action.jsp">
		<div class="box">
			<p>
				<input type="text" name="artist_name" placeholder="아티스트이름 입력" />
			</p>
			<p>
				<input type="text" name="artist_img" placeholder="아티스트 사진 경로 입력" />
			</p>
			<p>
				<input type="text" name="album_img" placeholder="앨범 사진 경로 입력" />
			</p>
			<p>
				<input type="text" name="album_name" placeholder="앨범 이름 입력" />
			</p>
			<p>
				<input type="text" name="name" placeholder="노래 이름 입력" />
			</p>
			<p>
				<input type="text" name="genre" placeholder="장르 입력" />
			</p>
			<p>
				<input type="number" name="playTime" placeholder="음악 길이 입력" />
			</p>
			<p>
				<textarea name="lyrics" rows="10" cols="80" placeholder="가사입력"
				style="resize:none"></textarea>
			</p>
			<p>
				<label><input type="radio" name="isTitle" value="1" required>타이틀</label>
				<label><input type="radio" name="isTitle" value="0" required>수록곡</label>
			</p>
			<p>
				<input type="submit">
				<a href="list.jsp"><input type="button" value="목록으로 이동"></a>
			</p>
		</div>
	</form>
</body>
</html>