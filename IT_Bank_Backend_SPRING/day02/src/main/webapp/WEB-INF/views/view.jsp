<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
    
<section class="frame">
	<div class="detail">
		<div><img src="${cpath }/resources/image/${dto.imgname}" height="300"></div> 
		<div><h3>${dto.name }</h3></div>
		<div><pre>${dto.memo }</pre></div>
		<div><h4>${dto.price }원</h4></div>
	</div>
	<div class="sb">
		<div>
			<a href="${cpath }"><button>목록</button></a>
		
		</div>
		<div>
			<a href="${cpath }/modify/${dto.idx}"><button>수정</button></a>
			<a href="${cpath }/delete/${dto.idx}"><button>삭제</button></a>
		
		</div>
	
	</div>
</section>

</body>
</html>