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
<h1> HttpSession - session변수</h1>
<%
		//세션의 유효시간 설정
		session.setMaxInactiveInterval(30);
%>
<h3>
	session.getId() : <%=session.getId()%><p>
	session.getMaxInactiveInterval() : <%=session.getMaxInactiveInterval()%><p>
	session.getCreationTime() : <%=session.getCreationTime()%><p>
	session.getLastAccessedTime() : <%=session.getLastAccessedTime()%><p>
	session.isNew() : <%=session.isNew()%><p>
	
	<hr>
	
	session에 정보 저장하기<p>
	<%
		session.setAttribute("id", "jang");
		session.setAttribute("addr", "판교");
		session.setAttribute("hobbys", new String[]{"등산","수영","축구"});
	%>
	
	<hr>
	session에 저장된 정보 확인하기<p>
	아이디: <%=session.getAttribute("id") %><br>
	주소: <%=session.getAttribute("addr") %><br>
	취미: <%=session.getAttribute("hobbys") %><br>
	<a href="sessionget.jsp">session정보 확인하러가자.</a>
	
</h3>
</body>
</html>