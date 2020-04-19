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
<table cellspacing="0" align="center">
   <caption><h2>${member.name}님 회원 정보</h2></caption>
  <tr>
	<td width="100px">ID</td>
	<td width="400px">${member.id}</td>
  </tr>
  <tr>
	<td>PWD</td>
	<td>${member.pwd}</td>
  </tr>
  <tr>
	<td>NAME</td>
	<td>${member.name}</td>
  </tr>
  <tr>
	<td>age</td>
	<td>${member.age}</td>
  </tr>
  <tr>
	<td>Phone</td>
	<td>${member.phone}</td>
  </tr>
  <tr>
	<td>Addr</td>
	<td>${member.addr}</td>
  </tr>
  <tr>
	<td>joinDate</td>
	<td>${member.joinDate}</td>
  </tr>
  <tr>
	<td colspan="2" style="text-align: center;background-color: pink">
	<a href="index.html">메인으로</a>
	</td>
	
  </tr>
  </table> 

</body>
</html>