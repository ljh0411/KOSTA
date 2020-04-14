<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
		width:500px;
		border: 5px double red;
		border-collapse: collapse;
}
th,td{border: 1px solid pink; padding: 5px; text-align: center;}
thead{background-color: yellow; color:red; }

</style>

<script>

</script>
</head>
<body>
<h1> &lt;c:forEach> TEST </h1>
<c:forEach begin="1" end="10" var="i">
${i} ,
</c:forEach>
<hr color="green">

<%
	String hobbys [] = {"등산","수영","낚시","골프"};
%>

<c:forEach items="<%=hobbys%>" var="h" varStatus = "state">
	${h} /${state.index} / ${state.count} <br>
	
</c:forEach>
<hr color="red">
<jsp:useBean id="bean" class="ex0414.jstl.ForEachBean"/>

<!-- name는 select박스로 출력 -->
<select>
	<option>--이름 선택--</option>
	<c:forEach items="${bean.names}" var="name">
		<option value="${name}">${name}</option>
	</c:forEach>
</select>
<br>
<!-- menus는 checkbox박스로 출력 -->
	<fieldset>
	<legend>메뉴선택</legend>
	<c:forEach items="${bean.menus}" var="m" varStatus="state">
		<input type="checkbox" name="m" value="${state.count}" >${m}
	</c:forEach>
	</fieldset>

<br>
<!-- memberList는 테이블로 출력 -->
	<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>나이</th>
			<th>주소</th>
			<th>연락처</th>
			
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${bean.memberList}" var="memberlist" varStatus="state">
	<tr>
		<td>${state.count}</td>
		<td>${memberlist.id}</td>
		<td>${memberlist.age}</td>
		<td>${memberlist.addr}</td>
		<td>${memberlist.phone}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
		
<br>
<!-- map는 radio박스로 출력 -->
<fieldset>
	<legend>메뉴선택</legend>
	<c:forEach items="${bean.map}" var="map">
	
	<input type="radio" name="nation" value="${map.key}" > ${map.value}
	</c:forEach>
</fieldset>

<hr>
 가격 : 275000000000원 / 
 <fmt:formatNumber value="275000000000"/>원
</body>
</html>