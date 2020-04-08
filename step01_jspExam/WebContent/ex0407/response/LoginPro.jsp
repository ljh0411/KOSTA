<%@page import="java.net.URLEncoder"%>
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
	<h1>response</h1>
	<% 
	String id = request.getParameter("userId");
	String pwd = request.getParameter("userPwd");
	String name = request.getParameter("userName");
	
	if("장".equals(id) && "1234".equals(pwd)){
		
		//새로운 request, response생성되어 이동하므로 필요한 정보 전송한다.
		//userName 이란 이름을 name값으로 UTF-8로 인코딩해서 넘겨주기
		//response.sendRedirect("LoginOk.jsp?userName="+URLEncoder.encode(name,"UTF-8"));
		
		//forward 방식으로 이동하기 - 메소드 이동
		RequestDispatcher rd = request.getRequestDispatcher("LoginOk.jsp");
		rd.forward(request, response);
	//상황에 따라서 버려야할때는 Redirect 값을 유지해야 할때는 forward를 사용한다.
	}else{
		
		out.println("<script>");
		out.println("alert('"+name+"님 정보를 확인해줘라...')");
		out.println("history.back()");
		out.println("</script>");
		
		
		//메시지 출력
		%><%-- 
			<script>
				alert("<%=name%>정보를 확인해주세요.");
			
				//location.href="LoginForm.html"; //자바스크립트에서 원하는 주소로 이동
				history.back();//비밀번호 제외한 나머지 정보 남기고 뒤로가기 			
			</script> --%>
		
		<%
		
		//response.sendRedirect("LoginForm.html"); 순서가 이게 먼저 실행되기때문에 자바스크립트랑 같이 쓸수 없다.
		
	}	
	
%>

</body>
</html>