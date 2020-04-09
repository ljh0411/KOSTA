<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   errorPage="error.jsp"%>
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
	//넘어오는 숫자 받아서 그 숫자로 나눈다
	int num = Integer.parseInt(request.getParameter("num1"));
	int result = 100/num;
%>
<h1>
	100 / <%=num%>=<%=result %>
</h1>

</body>
</html>