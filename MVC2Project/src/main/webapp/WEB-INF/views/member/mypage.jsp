<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>project/mypage.jsp</title>
<link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="wrap" style="min-height: 360px;">
<!-- 헤더들어가는 곳 -->
 <jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더들어가는 곳 -->
<!-- 본문들어가는 곳 -->
<!-- 본문 메인 이미지 -->
 <div ></div>
<!-- 본문 메인 이미지 -->
<!-- 왼쪽메뉴 -->
 <nav id="sub_menu">
  <ul>
   <li><a href="${pageContext.request.contextPath}/update">회원 정보 수정</a></li>
   <li><a href="${pageContext.request.contextPath}/delete">회원 탈퇴</a></li>
  </ul>
 </nav>
<!-- 왼쪽메뉴 -->
<!-- 본문내용 -->
 <article>
  <h1></h1>
 </article>
<!-- 본문내용 -->
<!-- 본문들어가는 곳 -->
<!-- 푸터틀어가는 곳 -->
 <jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터들어가는 곳 -->
</div>

</body>
</html>