<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>project/archive/content.jsp</title>
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
  <h1>archive Content</h1>
   <table id="notice">
	<tr>
	 <th>글번호</th>
	 <td>${archiveDTO.num}</td>
     <th>등록일</th>
     <td>${archiveDTO.date}</td>
    </tr>
    <tr>
	 <th>글쓴이</th>
	 <td>${archiveDTO.name}</td>
     <th>조회수</th>
     <td>${archiveDTO.readcount}</td>
    </tr>
    <tr>
     <th>제목</th>
     <td colspan="3">${archiveDTO.subject}</td>
    </tr>
    <tr>
     <th>파일</th>
     <td colspan="3">
      <a href="${pageContext.request.contextPath}/resources/upload/${archiveDTO.file}" download>
      ${archiveDTO.file}
      </a>
     </td>
    </tr>
    <tr>
     <th>내용</th>
     <td colspan="3">${archiveDTO.content}</td>
    </tr>
    <tr>
     <td colspan="4">
      <div id="table_btn">
		<input type="button" value="목록으로" class="btn" onclick="location.href='${pageContext.request.contextPath}/archive'" style="float: right;">
		 <c:if test="${!(empty sessionScope.id)}">
			<input type="button" value="삭제하기" class="btn" style="float: right;" 
       		 onclick="location.href='${pageContext.request.contextPath}/archive/delete?num=${archiveDTO.num}'">
       		<input type="button" value="수정하기" class="btn" style="float: right;" 
       		 onclick="location.href='${pageContext.request.contextPath}/archive/update?num=${archiveDTO.num}'">
		 </c:if>
	  </div>
     </td>
    </tr>
  </table>
</article>
<!-- 본문내용 -->
<!-- 본문들어가는 곳 -->
<!-- 푸터틀어가는 곳 -->
 <jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>