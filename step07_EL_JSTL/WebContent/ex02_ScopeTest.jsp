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
 requestScope 영역 <br>
 주소 : <%=request.getAttribute("addr")%>/${requestScope.addr} /${addr}<p>
 
 sessionScope 영역 <br>
 아이디 : <%=session.getAttribute("id")%>/${sessionScope.id} /${id}<p>
 메시지 : <%=session.getAttribute("message")%>/${sessionScope.message} /${message}<p>
 
 applicationScope영역<br>
 
 메시지 : <%=application.getAttribute("message")%>/${applicationScope.message} /${message}<p>
 취미 : <%=application.getAttribute("hobby")%>/${applicationScope.hobby} /${hobby}<p>
 

</body>
</html>