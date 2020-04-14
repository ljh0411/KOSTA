<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="error.jsp" %>
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
 	//넘어오는 두개의 값을 받고 숫자로 변환해서 합을 구한다.
 int num1 = Integer.parseInt(request.getParameter("num1"));
 int num2 = Integer.parseInt(request.getParameter("num2"));
 
 %>
<h1>두수의 합:<%=num1%>+<%=num2%>=<%=num1+num2%></h1>
</body>
</html>