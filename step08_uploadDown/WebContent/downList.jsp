<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h1> 다운로드 LIST</h1>
<ul>
<c:forEach items="${fileName}" var="fileName">

	<li><a href="downLoad?fileName=${fileName}">${fileName}</a></li>
	
</c:forEach>
</ul>
</body>
</html>