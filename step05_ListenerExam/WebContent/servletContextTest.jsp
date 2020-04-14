<%@page import="java.util.Map"%>
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
<h1>ServeltContextListener TEST</h1>
<fieldset>
	<legend>나라선택</legend>
	<%
		//나라정보 가져오기
		Map<String, String> map = (Map<String, String>)(application.getAttribute("map"));
		for(String key: map.keySet()){ //map에있는 key정보 다 가져오기
			String value = map.get(key);
			%>
			<input type="radio" name="nation" value="<%=key%>"><%=value%>
			<% 
		}
		%>

	
</fieldset>
	<hr>
	application.getContextPath() : <%=application.getContextPath() %><br>
	application.getAttribute("path") : <%=application.getAttribute("path") %><br>
	EL언어로 : ${applicationScope.path}<br>
	EL언어로 : ${path}<br>
</body>
</html>