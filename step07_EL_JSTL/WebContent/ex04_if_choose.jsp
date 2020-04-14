<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h2> &lt;c:if> , &lt;c:choose> TEST </h2>

<c:if test="${param.age>18}" var="re" >
	<h3>${param.age}살은 성인입니다.</h3>
</c:if>

결과 : ${re}

<hr>

<c:choose>
	<c:when test="${param.age >18 }">
	<h3>${param.age}살은 성인입니다.</h3>
	</c:when>
	<c:otherwise>
		<h3 style="color:red">${param.age}살은 미성년자 입니다.</h3>
	</c:otherwise>
</c:choose>

<hr color="red">
<form action="ex04_if_choose.jsp" method="get" name="f">
 이름: <input type="text" name="name" value="${param.name}"/> <br>
 선택 :
 <select name="job">
 	<option value="0">--선택--</option>
 	<option value="학생">학생</option>
 	<option value="개발자">개발자</option>
 	<option value="백수">백수</option>
 	<option value="백조">백조</option>
 
 </select>
 	<input type="submit" vlaue="전송">
</form>

<c:if test="${not empty param.name and param.job !=null}">
	<h3>
		${param.name}님 직업은 ${param.job}입니다.
	</h3>
</c:if>
<hr>

<c:choose>
	<c:when test="${param.job=='학생'}">
		<h2>공부하세요.</h2>
	</c:when>
	
		<c:when test="${param.job=='개발자'}">
		<h2>최고의 개발자가 되세요</h2>
	</c:when>
	
		<c:when test="${param.job=='백수'}">
		<h2>돈벌어오세여</h2>
	</c:when>
	
		<c:when test="${param.job=='백조'}">
		<h2>노세노세 젊어서 노세</h2>
	</c:when>
	
	<c:otherwise>
		<h1>선택사항없음</h1>
	</c:otherwise>

</c:choose>

<script>
	document.f.job.value="{param.job}";
</script>
</body>
</html>