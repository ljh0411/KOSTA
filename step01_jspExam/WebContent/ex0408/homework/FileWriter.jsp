<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	String realPath = application.getRealPath("ex0408/homework/save");
	
	long time = System.currentTimeMillis();
	String path = realPath + "/" + name+"_"+time+".txt";
	 
	BufferedWriter bw = 
			new BufferedWriter(new FileWriter(path));
	bw.write("이름 : "+name+"\n");
	bw.write("제목 : "+subject+"\n");
	bw.write("내용 : "+content+"\n");
	
	bw.flush();
	bw.close();
	
	//application영역에 realPath저장  한번 만들어놓으면 서버가 유지될동안 계속 쓸수있다.
	application.setAttribute("realPath", realPath);

    out.println("<script>alert('생성되었습니다.');location.href='FileReader.jsp';</script>");
%>


</body>
</html>