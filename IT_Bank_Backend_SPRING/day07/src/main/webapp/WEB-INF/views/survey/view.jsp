<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>


<section>
	<form method="POST">
		<h3>${dto.title }</h3>
		<input type="hidden" name="userid" value="${login.userid }">
		<input type="hidden" name="survey_idx" value="${dto.idx }">
		<div>
			<div class="flex">
				<p>
					<img src="${cpath }/upload/${dto.image1}" height="300" style="padding-right:150px;">
				</p>
				<p>
					<img src="${cpath }/upload/${dto.image2}" height="300">
				</p>
			</div>
			<div class="flex sa" style="width:1120px;">
				<p>${dto.content1 }</p>
				<p>${dto.content2 }</p>
			
			</div>
			
			<div class="flex sa" style="width:1120px;">
				<p>
					<label ><input type="radio" name="response" value="0" style="width:50px; height:50px;"></label>
				</p>
				<p>
					<label><input type="radio" name="response" value="1" style="width:50px; height:50px;"></label>
				</p>
			</div>
		</div>


		<p>
			<input type="submit">
		</p>
	</form>
</section>

</body>
</html>