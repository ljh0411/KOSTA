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
<h1>
	&lt;context-param&gt; 에 설정된 정보 확인하기<p>
	메시지 : <%=application.getInitParameter("message") %><p>
	나이 : <%=application.getInitParameter("age") %><p>
</h1>


</body>
</html>