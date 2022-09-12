<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>project/archive/update.jsp</title>
<link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
 <c:if test="${empty sessionScope.id}">
  <c:redirect  url="${pageContext.request.contextPath}/login"/>
 </c:if>
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
 <form action="${pageContext.request.contextPath}/archive/updatePro" id="board" method="post">
 <input type="hidden" name="num" value="${archiveDTO.num}">
<!--  <input type="hidden" name="pass" value="1234"> -->
 <h1>archive Update</h1>
  <table>
   <tr>
	<th>글쓴이</th>
	<td><input type="text" name="name" value="${sessionScope.id}" readonly></td>
	</tr>
    <tr>
     <th>제목</th>
     <td><input type="text" name="subject" value="${archiveDTO.subject}"></td>
    </tr>
    <tr>
     <th>파일 업로드</th>
     <td>
      <input type="file" name="file">
      <input type="hidden" name="oldfile" value="${archiveDTO.file}">
      ${archiveDTO.file}
     </td>
    </tr>
    <tr>
     <th>내용</th>
     <td><textarea rows="30" cols="50" name="content">${archiveDTO.content}</textarea></td>
    </tr>
    <tr>
     <td colspan="2">
      <div id="table_btn">
       <input type="button" value="목록으로"  class="btn" onclick="location.href='${pageContext.request.contextPath}/archive'" style="float: right;">
       <input type="submit" value="수정하기" class="btn" style="float: right;">
      </div>
     </td>
    </tr>
 </table>
</form>
<!-- 본문내용 -->
<!-- 본문들어가는 곳 -->
<!-- 푸터틀어가는 곳 -->
 <jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>