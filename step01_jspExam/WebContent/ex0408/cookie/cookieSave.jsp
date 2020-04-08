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
<h3> 쿠키 정보 저장하기 </h3>
<%
	//쿠키 생성하기
	Cookie co1 = new Cookie("id", "LEE");
	Cookie co2 = new Cookie("age", "20");
	
	//옵션 설정
	co1.setMaxAge(60*60*24);  //1일 동안만 유효
	co2.setMaxAge(60*60*24*365); // 1년 (0은 삭제, -1은 저장안함)
	
	co1.setPath("/");
	
	response.addCookie(co1);
	response.addCookie(co2);

%>
<h2>저장 완료</h2>
<a href="cookieGet.jsp">쿠키확인하러 가자.</a>

</body>
</html>