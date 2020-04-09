<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		response.setHeader("Cache-Control", "no-store");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
img{
	width:300px;
	hieght:300px;
}
</style>
<script src="../../js/jquery-3.4.1.min.js"></script>
<script>
$(function(){
	//로그아웃 버튼 클릭
	$("input[type=button]").click(function(){
		if(confirm("정말 아웃할래???")){
			//세션의 정보를 모두 지우기 위해 새로운 창으로 이동.
			
			location.href ="Logout.jsp";
			
		}
	});
});

</script>
</head>
<body>
	<h1>
<% 
	
	if(session.getAttribute("sessionName")==null){
		%>
		<srcipt> 
		alert("로그인하고 이용해주세요.")
		location.href = "LoginForm.html";
		</srcipt>

		<% 
				
			
		}else{
			%>
			<h3>
				[접속시간 : <%=session.getAttribute("sessionTime") %>]<p>
				<%=session.getAttribute("sessionName")%>님 로그인 성공!!!<p>
				<img src="images/common.jpg"/>
				<input type="button" value="로그아웃" />
			</h3>
			
			<%
			//response.sendRedirect("Logout.jsp");
		}

	
	
%>
	</h1>
</body>
</html>