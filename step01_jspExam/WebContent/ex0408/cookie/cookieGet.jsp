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
<h1> Cookie 정보 가져오기</h1>
<%
	//쿠키저옵가져오기
	Cookie []  cookies = request.getCookies();
	if(cookies == null){
		out.println("쿠키 정보가 없습니다.");
	}else{
		out.println("쿠키 개수 : "+cookies.length+"<br>");
		for(Cookie c :cookies){
			out.println(c.getName()+" = " + c.getValue()+"<br>");
		}
	}
%>
</body>
</html>