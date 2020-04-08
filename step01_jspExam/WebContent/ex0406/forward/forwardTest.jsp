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
<h1> forward 액션 태그</h1>
<%
	request.setCharacterEncoding("UTF-8");

	int sum=0;
	for(int i=0; i<=10; i++){
		//out.println(i+"<br>");
		sum+=i;//누적...
	}
%>

<jsp:forward page="forwardResult.jsp">
	<jsp:param name="total" value="<%=sum%>"/>
	<jsp:param name="name" value="준호"/>
</jsp:forward>
<%
	//기능 실행안됨 forward태그로 이동하면 밑으로 안내려온다.
%>
</body>
</html>