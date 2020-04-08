<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>

<script>

</script>
</head>
<body>
<%
//parameter 한글인코딩 설정
request.setCharacterEncoding("UTF-8");

	String addr="대구...";
%>

<h1>액션 태크 - include 개념</h1>

<jsp:include page="top.jsp"/> <!-- 사이에 컨텐츠가 없으면 끝에 /로 마무리 -->
<hr>
여기는 index 영역입니다.

<hr color="red">
<jsp:include page="footer.jsp">
	<jsp:param name="address" value="<%=addr%>"/>
	<jsp:param name="id" value="jang"/>
	

</jsp:include>

</body>
</html>