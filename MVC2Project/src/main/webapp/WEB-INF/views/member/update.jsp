<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>project/update.jsp</title>
<link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/subpage.css" rel="stylesheet" type="text/css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
function addr1() {
    new daum.Postcode({
        oncomplete: function (data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if (data.userSelectedType === 'R') {
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if (extraAddr !== '') {
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("address3").value = extraAddr;

            } else {
                document.getElementById("address3").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('address1').value = data.zonecode;
            document.getElementById("address2").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("address3").focus();
        }
    }).open({
    	popupTitle: '우편번호 검색'
    });
}
</script>
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
  <form action="${pageContext.request.contextPath}/updatePro" id="join" method="post">
    <table border="0" align="center" style="margin-left:380px">
     <tr>
      <td colspan="3" align="center">
       <h1>회원정보 페이지</h1>
      </td>
     </tr>
     <tr>
      <td valign="top">
       <div>
        <h2>회원 정보</h2>
         <div>
          <div>
           <div>
            아이디 <br>
            <input type="text" name="id" value="${memberDTO.id}" style="margin-bottom:5px" readonly>
           </div>
           <div>
            비밀번호 <br>
            <input type="password" name="pass" placeholder="비밀번호" required> <br>
<!--             비밀번호 확인 <br> -->
<!--             <input type="password" name="pass2" placeholder="비밀번호 확인" required> -->
           </div>
           <div>
            이름 <br>
            <input type="text" name="name" value="${memberDTO.name}" readonly>
           </div>
           <div>
            이메일 <br>
            <input type="email" name="email" value="${memberDTO.email}">
           </div>
           <div>
            주소 <br>
            <input type="text" name="address" value="${memberDTO.address}" id="address1" placeholder="우편번호" size="7"> 
			<input type="button" value="주소 찾기" onclick="addr1()"  ><br>
			<input type="text" name="address2" value="${memberDTO.address2}" id="address2" placeholder="주소" size="40" ><br>
			<input type="text" name="address3" value="${memberDTO.address3}" id="address3" placeholder="상세주소" size="40"><br>
           </div>
           <div>
            휴대 전화
            <input type="text" name="mobile" value="${memberDTO.mobile}">
           </div>
           <div>
            <input type="submit" value="회원정보 수정" style="cursor:pointer;"/>
            <a href="${pageContext.request.contextPath}/mypage"><input type="button" value="취소" class="cancel"></a>
           </div>
          </div>
         </div>
       </div>
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