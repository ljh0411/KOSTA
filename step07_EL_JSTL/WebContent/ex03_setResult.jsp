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
<h1>결과 확인하기</h1>
아이디 : ${id} / ${sessionScope.id}<br>
메시지 : ${message} / ${applicationScope.message}<br>
나이 : ${age}

<h3>제거(삭제)하기</h3>
<c:remove var="message"/>
<h1>결과 확인하기</h1>
아이디 : ${id} / ${sessionScope.id}<br>
메시지 : ${message} / ${applicationScope.message}<br>
나이 : ${age}
</body>
</html>