<%@page import="ex0413.el.Product"%>
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
<h1> EL - 표현언어 TEST</h1>
<h3>
\${5} = ${5} <br>
\${5+3} = ${5+3} <br>
\${5-2} = ${5-2} <br>
\${5 / 2} = ${5 / 2} <br>
\${5 gt 3} = ${5 gt 3} <br>
\${5 gt 3 and 3 eq 3} = ${5 gt 3 and 3 eq 3} <br>

\${5>3?"맞다" : "틀리다" } = ${5>3 ? "맞다":"틀리다" }<br>

<hr color="blue">
<!-- 만약 http://localhost:8888/step07_EL_JSTL/ex01_ELTest.jsp?age=25 
만약 age가 18보다 크면 성인입니다. 아니면 미성년자 입니다.-->
${param.age > 18 ? "성인" : "미성년자" }<br>

<!-- 
	만약 
	http://localhost:8888/step07_EL_JSTL/ex01_ELTest.jsp?age=25&id=jang
	
	만약 id가 있다면 id님 출력하고 없으면 Guest님 이라고 출력한다.
 -->
 
 ${param.id==null ? "Guest" : param.id}님<br>
 ${empty param.id ? "Guest" : param.id}님<p>
 
 ${param.id !=null ? param.id : "Guest"}님<br>
 ${not empty param.id ? param.id : "Guest"}님<br>
 
 ${not empty param.id ? param.id+="학생": "Guest님"}<br>
 ${not empty param.id ? param.id.concat("학생"): "Guest님"}<br>
 
 Scope에 저장된 데이터 EL로 출력하기 <p>
 
 <%
 	//scope영역에 데이터 저장
 	request.setAttribute("addr", "서울");
 
 	session.setAttribute("id", "jang");
 	session.setAttribute("message", "졸립다...");
 	
 	application.setAttribute("message", "우리모두 선거합시다...");
 	application.setAttribute("hobby", "먹고 놀기");
 %>
 requestScope 영역 <br>
 주소 : <%=request.getAttribute("addr")%>/${requestScope.addr} /${addr}<p>
 
 sessionScope 영역 <br>
 아이디 : <%=session.getAttribute("id")%>/${sessionScope.id} /${id}<p>
 메시지 : <%=session.getAttribute("message")%>/${sessionScope.message} /${message}<p>
 
 applicationScope영역<br>
 
 메시지 : <%=application.getAttribute("message")%>/${applicationScope.message} /${message}<p>
 취미 : <%=application.getAttribute("hobby")%>/${applicationScope.hobby} /${hobby}<p>
 
 <a href="ex02_ScopeTest.jsp">확인하러가기</a>
</h3>

<hr color="red">
<h3>
	product객체안에 있는 데이터 표현언어로 출력하기<p>
	<%-- 
		Product p = new Product();
	 --%>
	 
	 <jsp:useBean id="p" class="ex0413.el.Product"/>    <!-- Bean 객체 하나를 뜻함 useBean은 객체를 생성하겟다 -->
	
	코드:<%=p.getCode() %> / ${p.code} <p> <!-- p.getCode() 호출됨.-->
	이름:<%=p.getName() %> / ${p.name}<p>
	가격:<%=p.getPrice() %> / ${p.price}<p>
	수량:<%=p.getQty() %> / ${p.qty}<p>
	총금액:<%=p.getPrice()*p.getQty() %> / ${p.price * p.qty}<p>
</h3>

</body>
</html>