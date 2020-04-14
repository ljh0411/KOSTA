<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<h1> Upload Result</h1>
<h3>
	작성자:${requestScope.name}<p>
	제목: ${subject}<p>
	첨부파일이름(OriginalName): ${OriginalName}<p>
	첨부파일이름(systemName): ${systemName}<p>
	파일용량:<fmt:formatNumber value="${fileSize}"/>byte<p>
	저장경로:${saveDir}<p>
</h3>
</body>
</html>