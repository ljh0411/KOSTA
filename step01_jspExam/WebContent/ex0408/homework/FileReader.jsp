<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>저장된 폴더 목록 LIST </h1>
<%
	String realPath = (String)application.getAttribute("realPath");
	
	out.println("<h4>"+realPath+"</h4>");
	
	File path = new File(realPath);
	String [] fileList = path.list();
	
	out.println("<ul>");
	if(fileList != null){
		for(String f : fileList){
			out.println("<li>"+ f + "</li>");
			
	}
	out.println("</ul>");
 }
%>

<a href="board_Form.html">등록하기</a>
<!--
    작성자이름_시간.txt 으로 저장
    파일 경로
    파일 리스트
    새글 등록
    IO 이용해서 파일 생성
    alert로 생성되었습니다
    FileReader.jsp로 이동하여 찍어냄
    내용은 작성 제목 내용
-->
</body>
</html>