<%@page import="java.util.Date"%>
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
		//인증된 사용자의 정보를 session에 저장한다.
		session.setAttribute("sessionName", name);
		session.setAttribute("sessionTime", new Date().toLocaleString());
		//forward 방식으로 이동하기 - 메소드 이동
		//RequestDispatcher rd = request.getRequestDispatcher("LoginOk.jsp");
		//rd.forward(request, response);
		response.sendRedirect("LoginOk.jsp");  //이동하기
	}else{
		
		 out.println("<script>");
		out.println("alert('"+name+"님 정보를 확인해줘라...')");
		out.println("history.back()");
		out.println("</script>");
 
		//RequestDispatcher rd = request.getRequestDispatcher("LoginFail.jsp");
		//rd.forward(request, response);
		
	}	
	
%>

</body>
</html>