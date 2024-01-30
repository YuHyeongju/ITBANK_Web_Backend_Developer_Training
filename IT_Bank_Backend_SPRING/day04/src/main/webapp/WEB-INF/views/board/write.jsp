<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<style>
	h3{
		text-align: center;	
	}
	table {
		margin: 20px auto;
	}

</style>

<h3>게시글 작성</h3>
<form method="POST">
	<table>
		<tr>
			<td><input type="text" name="title" placeholder="제목"></td>
		</tr>
		<tr>
			<td><input type="text" name="writer" value="${login.userid }"
				readonly></td>
		</tr>
		<tr>
			<td><textarea name="content" placeholder="내용을 작성하세요"
					style="resize: none; width: 600px; height: 200px;"></textarea></td>
		</tr>

		<c:if test="${login.userid == 'root' }">
			<tr>
				<td><label> <input type="checkBox" name="isNotice"
						value="1">
						공지로 등록하기
					</label>
				</td>
			</tr>
		</c:if>
	</table>
	<div style="display: flex; width:600px; margin: 20px auto; justify-content: space-between;">
		<input type="submit" value="작성완료">
	</div>
	


</form>

</body>
</html>