<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="${pageContext.request.contextPath}/resources/css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 헤더들어가는 곳 -->
 <div></div>
<!-- 헤더들어가는 곳 -->
<!-- 본문들어가는 곳 -->
<!-- 본문 메인 이미지 -->
 <div></div>
<!-- 본문 메인 이미지 -->
<!-- 왼쪽메뉴 -->
 <nav></nav>
<!-- 왼쪽메뉴 -->
<!-- 본문내용 -->
<a href="${pageContext.request.contextPath}/main"><input type="button" value="메인화면" class="btn mainbtn"></a>
 <form action="${pageContext.request.contextPath}/loginPro" id="join" method="post">
    <table border="0" align="center" style="margin-top:50px">
     <tr>
      <td colspan="3" align="center">
       <h1>Login</h1>
      </td>
     </tr>
     <tr>
      <td valign="top">
       <div>
        <h2 align="center">회원 로그인</h2>
         <div>
          <div align="center">
           <div>
            <input type="text" name="id" placeholder="회원 아이디" style="margin-bottom:5px"/>
           </div>
           <div>
            <input type="password" name="pass" placeholder="비밀번호" style="margin-bottom:5px">
           </div>
           <div id="table_btn">
            <input type="submit" value="로그인" class="loginBtn" style="cursor:pointer;">
           </div>
          </div>
         </div>
       </div>
     </tr>
     <tr>
      <td>
       <div align="center">
        <p>아이디 찾기 | 비밀번호 찾기 | <a href="${pageContext.request.contextPath}/join">회원가입</a></p>
       </div>
      </td>
     </tr>
     
    </table>
 </form>
<!-- 본문내용 -->
<!-- 본문들어가는 곳 -->
<!-- 푸터틀어가는 곳 -->
 <div></div>
<!-- 푸터들어가는 곳 -->

</body>
</html>