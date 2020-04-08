<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
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
	<%--
		//apllication에 저장된 count수를 가져온다.

		Object obj = application.getAttribute("count");

		if (obj == null) {
			application.setAttribute("count", 0);
			obj = application.getAttribute("count");

		}
		//읽어온 값에 +1을 하고 다시 저장한다.
		int count = (Integer) obj;
		if (session.isNew()) {  // 현재 브라우져창의 세션이 새로운것인지 판별 (true면 새로운페이지, false 기존페이지)
			count++;
			application.setAttribute("count", count);
		}
		//최종값을 출력한다
	--%>
<% 
		//apllication에 저장된 count수를 가져온다.

		Object obj = application.getAttribute("count");

		if (obj == null) {
			application.setAttribute("count", new AtomicInteger());
			obj = application.getAttribute("count");

		}
		
		AtomicInteger it = (AtomicInteger)obj;
		int count = it.get(); //현재 값 가져오기
		if(session.isNew()){
			count = it.incrementAndGet();    //객체를 생성해서 저장했기때문에 다시 application으로 저장해줄 필요없다.
		}



%>

	<h3>
		방문자 수 : <%= count%>명
	</h3>

</body>
</html>