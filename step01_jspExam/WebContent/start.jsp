
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Start</h1>
<%
	//자바코드 작성
	String name ="이준호";

	out.println(name+"님 반가워요: ");
	System.out.println("난 어디서 출력되니??"); //콘솔에 출력됨
%>
<h3>오늘 점심은 뭐 먹지??</h3>
<%
	String menu = "짜장";
%>
<h3>메뉴 : <%=menu %></h3>

메소드 호출 : <%=test(20)%>

<%! 
	String name;
	int age;
	
	//메소드 선언
	public String test(int age){    //메소드 선언은 반드시 <%! !가 필요 
		System.out.println("test 메소드 호출 되었습니다...");
		return age+"살 입니다...";
	}

%>
<%
	Date today = new Date();
%>

<%=today.toLocaleString() %>
<hr>
<%
	out.print("졸립죠?<br>");
	out.print("<h1 Style='color:red'>자고싶다?</h1>");
	out.print("쉬고싶다...?<br>");
%>
<hr>
<%
	out.println("졸립죠?<br>");
	out.println("자고싶다?<br>");
	out.println("쉬고싶다...?<br>");
%>

</body>
</html>