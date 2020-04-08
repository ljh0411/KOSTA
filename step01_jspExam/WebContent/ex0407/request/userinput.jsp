<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>사용자 등록</title>

<link rel="stylesheet" href="stylecss.css" type="text/css">
</head>
 


<body bgcolor="#FFFFFF">
<table width="570" border="0" cellspacing="0" cellpadding="5">
  <tr bgcolor="#3399CC"> 
    <td height="30" class="normalbold"><font color="#FFFFFF">사용자 정보입력</font></td>
  </tr>
  <tr>
    <td class="normal">안녕하세요. 희정이의 홈페이지를 자유롭게 이용하려면 회원가입을 하셔야 합니다.<br>
      아래의 사항들을 빠짐없이 기록해 주세요.</td>
  </tr>
</table>
<form method="post" action="userPro.jsp" name="userinput">
  <table width="570" border="1" cellspacing="0" cellpadding="3" bordercolor="#000000">
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">사용자 ID</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="userid" size="20">
        <input type="button" name="confirm_id" value="ID중복확인" OnClick="">
      </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">비밀번호</div>
      </td>
      <td width="154" class="normal"> 
        <input type="password" name="userpass1">
      </td>
      <td width="141" class="normalbold" bgcolor="#FFCCCC"> 
        <div align="center">비밀번호 확인</div>
      </td>
      <td width="160"> 
        <input type="password" name="userpass2">
      </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179" height="23"> 
        <div align="center">사용자 이름</div>
      </td>
      <td colspan="3" height="23" class="normal"> 
        <input type="text" name="username">
      </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">주민등록번호</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="socialid1">
        - 
        <input type="text" name="socialid2">
      </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">생년월일</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="year">
        년 
        <select name="month">
          <option value="01">01</option>
          <option value="02">02</option>
          <option value="03">03</option>
          <option value="04">04</option>
          <option value="05">05</option>
          <option value="06">06</option>
          <option value="07">07</option>
          <option value="08">08</option>
          <option value="09">09</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
        </select>
        월 
        <select name="day">
          <option value="01">01</option>
          <option value="02">02</option>
          <option value="03">03</option>
          <option value="04">04</option>
          <option value="05">05</option>
          <option value="06">06</option>
          <option value="07">07</option>
          <option value="08">08</option>
          <option value="09">09</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
          <option value="13">13</option>
          <option value="14">14</option>
          <option value="15">15</option>
          <option value="16">16</option>
          <option value="17">17</option>
          <option value="18">18</option>
          <option value="19">19</option>
          <option value="20">20</option>
          <option value="21">21</option>
          <option value="22">22</option>
          <option value="23">23</option>
          <option value="24">24</option>
          <option value="25">25</option>
          <option value="26">26</option>
          <option value="27">27</option>
          <option value="28">28</option>
          <option value="29">29</option>
          <option value="30">30</option>
          <option value="31">31</option>
        </select>
        일 </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">우편번호</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="zip1" >
        - 
        <input type="text" name="zip2" >
		<input type="button" name="serach" value="우편번호검색" 
		onClick="">
      </td>
    </tr>
   <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">주 소</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="address1" size="70" >
      </td>
    </tr>
	<tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">나머지주소</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="address2" size="30">
      </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">E-Mail</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="email1">@
		<select name="email2" onchange="" >
			<option value="0">선택하세요
			<option value="daum.net">daum.net
			<option value="yahoo.co.kr">yahoo.co.kr
			<option value="naver.com">naver.com
			<option value="empas.com">empas.com
			<option value="dir" >직접입력
		</select>
		<input type="text" name="email3" value="" style="visibility:hidden" id="em3">
		<script>
		function em_direct(em){
			if(em.value=="dir"){	
				document.all.em3.style.visibility="visible";
			}else{
				document.all.em3.style.visibility="hidden";
			}
		}
		</script>
      </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">직업</div>
      </td>
      <td colspan="3" class="normal"> 
        <select name="job">
          <option value="컴퓨터/정보통신">컴퓨터/정보통신</option>
          <option value="문화/예술">문화/예술</option>
          <option value="회사원">회사원</option>
          <option value="학교/학원">학교/학원</option>
          <option value="대학생">대학생</option>
          <option value="초.중.고등학생">초.중.고등학생</option>
          <option value="주부">주부</option>
          <option value="기타">기타</option>
        </select>
      </td>
    </tr>
    <tr> 
      <td colspan="4" class="normal"> 
        <div align="center"> 
          <input type="submit" name="confirm" value="등   록" >
          <input type="reset" name="reset" value="취   소">
        </div>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
