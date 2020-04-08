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
<%--
	String addr="경기도 판교...";
--%>
<%
	//parameter로 전송된 데이터 받기(request 전송)
	String addr = request.getParameter("address");
	String id = request.getParameter("id");
%>

<h1> footer.jsp 문서입니다. </h1>
<h1>주소 : <%=addr%> / <%=id%></h1>
</body>
</html>