
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
	//�ڹ��ڵ� �ۼ�
	String name ="����ȣ";

	out.println(name+"�� �ݰ�����: ");
	System.out.println("�� ��� ��µǴ�??"); //�ֿܼ� ��µ�
%>
<h3>���� ������ �� ����??</h3>
<%
	String menu = "¥��";
%>
<h3>�޴� : <%=menu %></h3>

�޼ҵ� ȣ�� : <%=test(20)%>

<%! 
	String name;
	int age;
	
	//�޼ҵ� ����
	public String test(int age){    //�޼ҵ� ������ �ݵ�� <%! !�� �ʿ� 
		System.out.println("test �޼ҵ� ȣ�� �Ǿ����ϴ�...");
		return age+"�� �Դϴ�...";
	}

%>
<%
	Date today = new Date();
%>

<%=today.toLocaleString() %>
<hr>
<%
	out.print("������?<br>");
	out.print("<h1 Style='color:red'>�ڰ�ʹ�?</h1>");
	out.print("����ʹ�...?<br>");
%>
<hr>
<%
	out.println("������?<br>");
	out.println("�ڰ�ʹ�?<br>");
	out.println("����ʹ�...?<br>");
%>

</body>
</html>