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
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String  age = request.getParameter("age");
	String hobbys [] = request.getParameterValues("hobby");
	String ip = request.getRemoteAddr() ;
%>
<h3>
이름 :<%=name%> <br>
나이 :<%=age%>  <br>

<!-- 취미는 하나의 name으로 값 여러개 받기 -->
취미 :
<%
		for(String h : hobbys){
			out.print(h+",");
		}
%>  <br>
접속자 IP :<%=ip%> <br>
</h3>

</body>
</html>