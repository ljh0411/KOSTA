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

<h1> include 지시어 </h1>
<!--
	include지시어의 특징은 include된 파일의 소스가
	메인 페이지에 포함되어 서블릿 문서는 한개만 작성된다.
	그래서, 변수를 공유 할 수 있고 반면 동일한 이름의 변수를 include된
	문서에서 또 선언 할 수 없다. 
 -->

<%
	String addr="제주도...";
%>

<%@ include file="top.jsp"%>
<hr>
여기는 index.jsp에 부분입니다...

<%@ include file="footer.jsp" %>
</body>
</html>