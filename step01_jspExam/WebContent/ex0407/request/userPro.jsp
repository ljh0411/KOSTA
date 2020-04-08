<%@page import="java.util.Enumeration"%>
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
<h1> 회원가입 정보 확인하기</h1>
<%
	request.setCharacterEncoding("UTF-8");

	Enumeration<String> e = request.getParameterNames();
	while(e.hasMoreElements()){
	String name = e.nextElement();
	String value = request.getParameter(name);
	 out.println(name+" : "+value+"<br>");
}

%>
<hr>

request.getContextPath() : <%=request.getContextPath() %><p>
request.getRealPath("/") : <%=request.getRealPath("/") %><p>

request.getRequestURI() : <%=request.getRequestURI() %><p>
request.getRequestURL() : <%=request.getRequestURL() %><p>
</body>
</html>