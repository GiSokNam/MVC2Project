<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<!-- <link href="../css/default.css" rel="stylesheet" type="text/css"> -->
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
<script type="text/javascript">

	var checkIdResult = true; 			// 아이디 중복 확인 여부
	var checkPassResult = false; 		// 비밀번호 검사 
	var checkRetypePassResult = false; 	// 비밀번호 확인 결과 
	
	
	// 패스워드 보안강도 검사
	function checkPass(pass){
		// 패스워드 검사를 위한 정규표현식 패턴 작성 및 검사 결과에 따른 변수값 변경
		var spanElem = document.getElementById("checkPassResult");
		
		
		// 정규표현식 패턴 정의
		var lengthRegex = /^[A-Za-z0-9!@#$%]{8,16}$/; // 길이 및 사용 가능 문자 규칙
		var engUpperRegex = /[A-Z]/; 	// 대문자
		var engLowerRegex = /[a-z]/; 	// 소문자
		var numRegex = /[0-9]/; 		// 숫자
		var specRegex = /[!@#$%]/; 	// 특수문자
		
		var count = 0; // 각 규칙별 검사 결과를 카운팅 할 변수
		
		if(lengthRegex.exec(pass)){ // 패스워드 길이 및 사용 가능 문자 규칙 통과 시
			
			spanElem.innerHTML = "사용 가능한 패스워드";
			spanElem.style.color = "GREEN";
			
			// 각 규칙별 검사 후 해당 항목이 포함되어 있을 경우 카운트 증가
			if(engUpperRegex.exec(pass)) count++;
			if(engLowerRegex.exec(pass)) count++;
			if(numRegex.exec(pass)) count++;
			if(specRegex.exec(pass)) count++;
			
			
			switch (count) {
			case 4: 
				spanElem.innerHTML = "사용 가능한 패스워드(안전)";
				spanElem.style.color = "GREEN";
				checkPassResult = true;
				break; // 특수문자, 대문자, 소문자, 숫자 중 4개 만족
			case 3: 
				spanElem.innerHTML = "사용 가능한 패스워드(보통)";
				spanElem.style.color = "gray";
				checkPassResult = true;
				break; // 특수문자, 대문자, 소문자, 숫자 중 3개 만족
			case 2: 
				spanElem.innerHTML = "사용 가능한 패스워드(위험)";
				spanElem.style.color = "RED";
				checkPassResult = true;
				break; // 특수문자, 대문자, 소문자, 숫자 중 2개 만족
			default:
				spanElem.innerHTML = "영문자, 숫자, 특수문자 중 2가지 이상조합 필수!";
				spanElem.style.color = "RED";
				checkPassResult = false;
				break; // 특수문자, 대문자, 소문자, 숫자 중 1개 만족
			}
			
			
		} else {
			
			//spanElem.innerHTML = "사용 불가능한 패스워드";
			spanElem.innerHTML = "영문자, 숫자, 특수문자 조합 8 ~ 16자리 필수";
			spanElem.style.color = "RED";
			checkPassResult = false;
		}
		
		
	}
	
	// 패스워드 일치 여부 검사
	function checkRetypePass(pass2) {
		
		var pass = document.fr.pass.value;
		var spanElem = document.getElementById("checkRetypePassResult");
		
		if(pass == "" && pass2 == ""){
			spanElem.innerHTML = "패스워드 입력하세요";
			spanElem.style.color = "RED";
			checkRetypePassResult = false;
		} else if(pass == pass2) {// 패스워드 일치
			spanElem.innerHTML = "패스워드 일치";
			spanElem.style.color = "GREEN";
			checkRetypePassResult = true;
		} else {  // 패스워드 불일치
			spanElem.innerHTML = "패스워드 불일치";
			spanElem.style.color = "RED";
			checkRetypePassResult = false;
		}
	}
	
	function checkSubmit() {
		if(!checkIdResult){
			alert("아이디 중복 확인 필수!");
			document.fr.id.focus();
			return false;
		} else if(!checkPassResult){
			alert("올바른 패스워드 입력 필수!");
			document.fr.pass.focus();
			return false;
		} else if(!checkRetypePassResult){
			alert("패스워드 확인 필수!");
			document.fr.pass2.focus();
			return false;
		}
		
// 		return true;
	}

</script>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/script/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('.id').blur(function(){
			
			var sp ="아이디를 입력하세요"
			if($('.id').val()==""){
				$('#dupdiv').html(sp);
			}
			
			if($('.id').val()!=""){
//	          dupCheck.jsp 갈때   class="id" val()을 들고 가서 아이디 중복체크 하고 
//	          그결과를 가져와서  id="dupdiv" 내용 변경
				$.ajax({
					url:'${pageContext.request.contextPath }/member/dupCheck',
					data:{'id':$('.id').val()},
					success:function(rdata){
						if(rdata=="iddup"){
							rdata="아이디 중복";
						}else {
							rdata="아이디 사용가능";
						}
						$('#dupdiv').html(rdata);
					}
				});
				
			}
			
			
		});
		
	});
</script>
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
 <form action="${pageContext.request.contextPath}/joinPro" id="join" method="post" name="fr" onsubmit="return checkSubmit()">
    <table border="0" align="center" style="margin-top:50px">
     <tr>
      <td colspan="3" align="center">
       <h1>회원가입 페이지</h1>
      </td>
     </tr>
     <tr>
      <td valign="top">
       <div style="width: 550px; margin-left: 230px;">
        <h2>회원 가입</h2>
         <div>
          <div>
           <div>
            아이디 <br>
            <input type="text" name="id" class="id"  placeholder="회원 아이디" style="margin-bottom:5px" >
            <label></label><div id="dupdiv"></div><br>
            
           </div>
           <div>
            비밀번호 <br>
            <input type="password" name="pass" placeholder="비밀번호" onkeyup="checkPass(this.value)">
            <span id="checkPassResult"><!-- 패스워드 규칙 판별 결과 표시 영역 --></span> <br>
            비밀번호 확인 <br>
<!--             <input type="password" name="pass2" placeholder="비밀번호 확인" required onchange="pwdCheck1()"> -->
            <input type="password" name="pass2" placeholder="비밀번호 확인" onblur="checkRetypePass(this.value)">
            <span id="checkRetypePassResult"><!-- 패스워드 일치 여부 표시 영역  --></span>
           </div>
           <div>
            이름 <br>
            <input type="text" name="name" >
           </div>
           <div>
            이메일 <br>
            <input type="email" name="email" >
           </div>
           <div>
            주소 <br>
            <input type="text" name="address" id="address1" placeholder="우편번호" size="7"> 
			<input type="button" value="주소 찾기" onclick="addr1()" ><br>
			<input type="text" name="address2" id="address2" placeholder="주소" size="40" ><br>
			<input type="text" name="address3" id="address3" placeholder="상세주소" size="40"><br>
           </div>
           <div>
            휴대 전화
            <input type="text" name="mobile">
           </div>
           <div id="table_btn">
            <input type="submit" value="가입하기" class="btn">
            
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
 <div></div>
<!-- 푸터들어가는 곳 -->

</body>
</html>