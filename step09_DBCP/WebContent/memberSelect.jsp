<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  table{width:100%; border:5px dobule red}
  th,td{padding:5px; border: 1px solid pink ; text-align: center }
  a{text-decoration: none}
 </style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//검색버튼을 클릭했을때 유효성체크
	$("input[value=검색]").click(function(){
	 	if($("[name=keyField]").val()=="0"){
	 		alert("검색필드를 선택해주세요.");
	 		$("[name=keyField]").focus();//커서놓기
			return;
	 	}
	 	
	 	if($("[name=keyWord]").val()==""){
	 		alert("검색단어를 선택해주세요.");
	 		$("[name=keyWord]").focus();//커서놓기
			return;
	 	}
	 	
	 	//전송하기
	 	$("form[name=search]").submit(); //전송해라. -> action에 설정된 페이지로 이동.
	 	
	 	
	});//검색 버튼 클릭 끝

	
	//삭제를 클릭했을때
	$("button[type='button']").click(function(){
		if(confirm("정말 삭제 하실래요?")){
			var id = $(this).parent().parent().find("td:first").next().text();
			
			//location.href="delete?id="+id;
			$("input[name=id]").val(id);
			$("form[name=del]").submit();
		}
		
	});//삭제 끝
});


</script>

</head>

<body>




<center>
 <h1>[ 회원 정보 LIST ]</h1>
<table cellspacing="0">
  <tr>
    <th colspan="9" style="text-align:right">
      <a href="memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp;
      <a href="#">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;
    </th>
  </tr>
  
  <tr bgColor="pink">
    <th>번호</th>
    <th>아이디</th>
    <th>비밀번호</th>
    <th>이름</th>
    <th>나이</th>
    <th>주소</th>
    <th>연락처</th>
    <th>가입일</th>
    <th>삭제</th>
    
  </tr>

  <c:forEach items="${list}" var="memberlist" varStatus="state">
  <tr >
    <td>${state.count}</td>
    <td><a href="read?id=${memberlist.id}">${memberlist.id}</a></td> <!-- 상세보기 페이지만들기 -->
    <td>${memberlist.pwd}</td>
    <td>${memberlist.name}</td>
    <td>${memberlist.age}</td>
    <td>${memberlist.addr}</td>
    <td>${memberlist.phone}</td>
    <td>${memberlist.joinDate}</td>
    <td><button type="button">삭제</button></td>
  </tr>
  </c:forEach>
 
</table>
<p>

<form name="search" action="search" method="post">
 <select name="keyField">
   <option value="0">--선택--</option>
   <option value="id">아이디</option>
   <option value="name">이름</option>
   <option value="addr">주소</option>
 </select>
 
<input type="text" name="keyWord"/>
<input type="button" value="검색" />  

</form>

<form name = "del" action="delete" method="post">
<input type="hidden" name="id">

</form>



</center>



</body>
</html>




