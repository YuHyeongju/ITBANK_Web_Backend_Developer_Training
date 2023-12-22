<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<section>
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
					style="resize: none"></textarea>
			</p>
			<p>
				<label><input type="radio" name="isTitle" value="1" required>타이틀</label>
				<label><input type="radio" name="isTitle" value="0" required>수록곡</label>
			</p>
			<p>
				<input type="submit"> <a href="header.jsp"><input
					type="button" value="목록으로 이동"></a>
			</p>
		</div>
	</form>
</section>
</body>
</html>