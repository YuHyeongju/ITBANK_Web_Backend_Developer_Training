<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<script>
	const url = '${url}'
	const msg = '${msg}'
	const cpath = '${cpath}'
	
	/* if(url == '' && msg == ''){
		alert('관리자만 접근 가능합니다.')
		location.href = cpath + url
	}	 */
	
	
	if(url == ''){
		history.go(-1)
	}
	else{
		 alert(msg)
		 location.href = cpath + url
	}
</script>

</body>
</html>