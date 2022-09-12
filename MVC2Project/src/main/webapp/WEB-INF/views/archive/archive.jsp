<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실</title>
<link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
 <div id="wrap">
<!-- 헤더들어가는 곳 -->
 <jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더들어가는 곳 -->
<!-- 본문들어가는 곳 -->
<!-- 본문 메인 이미지 -->
 <div ></div>
<!-- 본문 메인 이미지 -->
<!-- 왼쪽메뉴 -->
 <nav></nav>
<!-- 왼쪽메뉴 -->
<!-- 본문내용 -->
 <article>
  <h1>자료실</h1>
   <table id="notice">
    <tr>
     <th class="tno">번호</th>
     <th class="twrite">글쓴이</th>
     <th class="ttitle">제목</th>
     <th class="tdate">등록일</th>
     <th class="tread">조회</th>
    </tr>
     <c:forEach var="archiveDTO" items="${archiveList}">
 	  	<tr>
  	     <td>${archiveDTO.num}</td>
  	     <td>${archiveDTO.name}</td>
  	     <td class="left"><a href="${pageContext.request.contextPath}/archive/content?num=${archiveDTO.num}"> ${archiveDTO.subject}</a></td>
  	     <td><fmt:formatDate value="${archiveDTO.date}" pattern="yyyy.MM.dd"/></td>
  	     <td>${archiveDTO.readcount}</td>
 	 	</tr>
 	 </c:forEach>
   </table>
   <div id="table_btn">
	 <c:if test="${!(empty sessionScope.id)}">
    	<a href="${pageContext.request.contextPath}/archive/write"><input type="button" value="글쓰기" class="btn"></a>
	 </c:if>
   </div>
   <br>
   <div id="page_control">
	<c:if test="${pageDTO.startPage > pageDTO.pageBlock }">
	 <a href="${pageContext.request.contextPath}/archive?pageNum=${pageDTO.startPage - pageDTO.pageBlock}">이전</a>
	</c:if>
	 <c:forEach var="i" begin="${pageDTO.startPage }" end="${pageDTO.endPage }" step="1" >
	  <a href="${pageContext.request.contextPath}/archive?pageNum=${i}">${i}</a>
	 </c:forEach>
	<c:if test="${pageDTO.endPage < pageDTO.pageCount }">
	 <a href="${pageContext.request.contextPath}/archive?pageNum=${pageDTO.startPage + pageDTO.pageBlock}">다음</a>
	</c:if>
  </div>
 </article>
<!-- 본문내용 -->
<!-- 본문들어가는 곳 -->
<!-- 푸터틀어가는 곳 -->
 <jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>