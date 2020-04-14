<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h2> &lt;c:set> , &lt;c:out>, &lt;c:remove> TEST  </h2>
<c:out value="안녕"/> / ${"안녕"} <p>

<c:out value="<h2>안녕</h2>" escapeXml="true"/> <hr>
<c:out value="<h2>안녕</h2>" escapeXml="false"/>

<c:set var="id" value="jang" scope="session"/>
<c:set var="message" value="월요일이다." scope="application"/>
<c:set var="age" value="20"/>

아이디: ${id} / <c:out value="${id}"/><p>
메시지: ${message} / <c:out value="${message}"/><p>
나이: ${age} / <c:out value="${age}"/><p>

<%
	String addr="경기도 대왕판교로...";
	//addr 표현언어로 사용하려면 xxxScope영역에 저장되어야한다.
	//request.setAttribute("addr", addr);
%>
<c:set var="addr" value="<%=addr %>"/>   <!-- 얘가 위의 주석 두줄을 대신해준다. -->
주소:${addr} <p>

<a href="ex03_setResult.jsp">확인하러가자</a>
</body>
</html>