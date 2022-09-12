<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
 <c:if test="${!(empty sessionScope.id)}">
 	<div id="login">
	 ${sessionScope.id}님 로그인 중 | 
	 <a href="${pageContext.request.contextPath}/logout">로그아웃</a> | 
	 <a href="${pageContext.request.contextPath}/mypage">마이페이지</a>
	</div>
 </c:if>
	
 <c:if test="${empty sessionScope.id}">
 	<div id="login">
	 <a href="${pageContext.request.contextPath}/login">로그인</a> | 
	 <a href="${pageContext.request.contextPath}/join">회원가입</a>
	</div>
 </c:if>	

<div class="clear"></div>
<div id="logo">
 <a href="${pageContext.request.contextPath}/main"><img src="${pageContext.request.contextPath}/resources/images/projectImg.png" width="265" height="62" alt="project"></a>
</div>
	<nav id="top_menu">
     <ul>
      <li><a href="${pageContext.request.contextPath}/notice">공지사항</a></li>
      <li><a href="${pageContext.request.contextPath}/board">커뮤니티</a></li>
      <li><a href="${pageContext.request.contextPath}/gallery">갤러리</a></li>
      <li><a href="${pageContext.request.contextPath}/archive">자료실</a></li>
     </ul>
    </nav>
</header>