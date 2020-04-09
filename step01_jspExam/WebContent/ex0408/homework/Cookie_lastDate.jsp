
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

//*필요한 변수 선언
 boolean state= false; //--쿠키존재여부를 판별(false-없음, true -있음)
 String message=""; //-출력할 변수
 long time = System.currentTimeMillis();  //-현재시간을 저장할 변수(System.currentTimeMills();)
 Cookie lastDate =null;  //-Cookie 저장할 변수

 
 /*1. 마지막 방문 일을 표시하는 웹페이지에 방문한 적이 있는지 
 없는지 체크. (저장된 쿠키를 가져와서 쿠키의 길이만큼 반복하여
  마지막일을 저장한 쿠키의 이름을 찾으면 쿠키존재여부를
 판별하는 변수의 값을 true로 변경한다.)*/
 
  Cookie [] cookie = request.getCookies();
  
  
 if(cookie != null){ //값이 없어서 널 포인트 Exception
	 //out.println(cookie.length+"<br>");
  for(Cookie co : cookie){
	  if(co.getName().equals("lastDate")){//찾는쿠키가존재한다면, 
		  state=true;
		  lastDate =co;
		  break; //더이상 반복문 돌지읺고 원하는 것을 찾으면 빠져 나옴
	  }
  }
}
  ///////////////////////////////////////
 
 if(!state){//2. 쿠키 없으면 현재날짜를 저장하는 쿠키생성하여 저장한다.
	lastDate = new Cookie("lastDate", time+""); 
	lastDate.setMaxAge(60*60*24*365);
	lastDate.setPath("/");
	
	response.addCookie(lastDate);//클라이언트 PC에저장한다.
	message="당신은 처음 방문하셨습니다.";

 }else{//3. 쿠키 있으면 이전쿠키가 저장한 날짜를 가져와서 출력할 변수에 저장한다.
	 Date date = new Date(new Long(lastDate.getValue())); //데이트 타입이 long이므로(쿠키의 반환 값은 스트링) long형으로 변환 
     message="당신의 마지막 접속일은 "+ date.toLocaleString(); //과거날짜
     
    // 4.현재 방문한 시점의 시간을 쿠키의 새로운 값으로 설정
     //-쿠키의 setValue를 이용하여 쿠키의 새로운값으로 변경
    //  -쿠키를 클라이언트쪽에 다시저장한다.
   
    lastDate.setMaxAge(60*60*24*365);
    lastDate.setPath("/"); //접근제한 설정용도로 쓰임
    lastDate.setValue(time+"");//수정
    response.addCookie(lastDate);//변경된 내용을클라이언트쪽에저장
 
 }

%>
<h2 align="center">
 <%=message%><p> <!-- 과거날짜 출력 -->
 
 현재접속시간 : <%=new Date(time).toLocaleString() %><br>
 다시 저장된 시간 : <%=time %>
</h2>


</body>
</html>










