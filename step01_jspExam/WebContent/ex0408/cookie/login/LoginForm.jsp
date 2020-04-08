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
<%
	//저장된 id 쿠키에 있는지 찾는다.
	Cookie [] cookies = request.getCookies();
	String lastId="";
	if(cookies!=null){
		for(Cookie co : cookies){
			if(co.getName().equals("lastId")){
				lastId = co.getValue();
				break;
			}
		}
	}


%>
<h2> 회원 인증 Page</h2>

<form method="get" action="LoginPro.jsp">
  ID : <input type="text" name="userId"  value="<%=lastId%>"/><br/>
  PWD : <input type="password" name="userPwd" /></br/>
  NAME : <input type="text" name="userName" /></br/>
  
  
  <input type="submit" value="로그인" />
</form>

</body>
</html>