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
<% 
	
	String name = request.getParameter("userName");
 
	out.print(name+"님 로그인 되었습니다.");
%>
</h1>
</body>
</html>