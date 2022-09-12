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
  <h1>갤러리</h1>
   <table id="notice">
    <tr>
     <th class="tno"></th>
     <th class="twrite"></th>
     <th class="ttitle"></th>
     <th class="tdate"></th>
     <th class="tread"></th>
    </tr>
    <tr>
	 <c:forEach var="galleryDTO" items="${galleryList}">
 	  	 <td>
 	  	  <a href="${pageContext.request.contextPath}/gallery/content?num=${galleryDTO.num}">
 	  	  <img src="${pageContext.request.contextPath}/resources/upload/${galleryDTO.file}" width="150" height="150">
 	  	  </a>
 	  	  <br>
 	  	  ${galleryDTO.subject}<br>
 	  	  ${galleryDTO.name}<br>
 	  	  <fmt:formatDate value="${archiveDTO.date}" pattern="yyyy.MM.dd"/><br>
 	  	 </td>
 		<c:if test="${(i+1)%4 == 0}">
 			</tr><tr>
 		</c:if>
     </c:forEach>
    </tr>
   </table>
   <div id="table_btn">
	 <c:if test="${!(empty sessionScope.id)}">
    	<a href="${pageContext.request.contextPath}/gallery/write"><input type="button" value="글쓰기" class="btn"></a>
	 </c:if>
   </div>
   <br>
   <div id="page_control">
	<c:if test="${pageDTO.startPage > pageDTO.pageBlock }">
	 <a href="${pageContext.request.contextPath}/gallery?pageNum=${pageDTO.startPage - pageDTO.pageBlock}">이전</a>
	</c:if>
	 <c:forEach var="i" begin="${pageDTO.startPage }" end="${pageDTO.endPage }" step="1" >
	  <a href="${pageContext.request.contextPath}/gallery?pageNum=${i}">${i}</a>
	 </c:forEach>
	<c:if test="${pageDTO.endPage < pageDTO.pageCount }">
	 <a href="${pageContext.request.contextPath}/gallery?pageNum=${pageDTO.startPage + pageDTO.pageBlock}">다음</a>
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