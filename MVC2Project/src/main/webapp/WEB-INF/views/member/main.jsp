<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/subpage.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function() {
// 	$('#btn').click(function() {
		$.ajax({
			url:'${pageContext.request.contextPath}/notice/listjson',
			dataType:'json',
			success:function(rdata){
				$.each(rdata,function(index,item){
					$('table').append("<tr><td class='contxt'><a href='${pageContext.request.contextPath}/notice/content?num="+item.num+"'>"+item.subject +"</a></td><td>"+ item.date +"</td></tr>");
				});
			}
		});
// 	});
});
</script>
</head>
<body>
 <div id="wrap" style="min-height: 640px;">
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

<div id="news_notice">
 <h3 class="brown">공지사항 
 <a href="${pageContext.request.contextPath}/notice" style="margin-left: 20em;">
 more</a></h3>
<!--  <input type="button" value="new" id="btn"> -->
  <table>
<!--    <tr><td class="contxt"><a href="#">subject</a></td><td>2012.11.02</td></tr> -->
<!--    <tr><td class="contxt"><a href="#"></a></td><td></td></tr> -->
  </table>
</div>
<!-- 본문내용 -->
<!-- 본문들어가는 곳 -->
<!-- 푸터틀어가는 곳 -->
 <jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터들어가는 곳 -->
 </div>
</body>
</html>