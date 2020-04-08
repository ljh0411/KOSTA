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
<--%
	//post방식으로 전송되는 데이터 한글 인코딩 처리
	request.setCharacterEncoding("UTF-8");
	//전송되는 parameter 받기

	String name = request.getParameter("name");
	String blood= request.getParameter("blood"); 
	out.println("이름 : "+name+"<p>");
	out.println("혈액형 : "+blood);

%>
<% 
	request.setCharacterEncoding("UTF-8"); // post방식 한글깨짐 해결
	String blood= request.getParameter("blood"); 
%>


<jsp:forward page='<%=blood+".jsp"%>'/>



</body>
</html>