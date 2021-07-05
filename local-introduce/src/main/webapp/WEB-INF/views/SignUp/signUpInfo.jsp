<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <script src="http://code.jquery.com/jquery-latest.js"></script> 
	<title>회원가입정보입력</title>
</head>
<body>
		<div id = "popUpDiv" style = "width:  100% ; height: 100%;">
				<form id = "loginFrm"  method="post" action = "/checkLogin">
					<div id = "userInfo">
						<input type = "text" id = "userId"  name = "userId" placeholder="아이디(ID)"/> <button id = "duCheck"  name = "duCheck">중복확인</button> <br>
						<input type = "text" id =  "userNm"  name =  "userNm"  placeholder="이름"/><br>
						<input type = "text"  id = "userPw" name = "userPw" placeholder="비밀번호(PW)" style = "margin-top:  5px;"/>
					</div>
				</form>
				
				<div id = "btnDiv" style = "margin-top:  5px; ">
					<button id = "btnSave">가입하기</button>
					<button id = "btnCancel">취소</button>
				</div>
		</div>
</body>
<script type="text/javascript"  charset="utf-8">
var  duChkYn = "N";
$("document").ready(function (){
	$("#userId").focus();	
	setEventListner();
});

function setEventListner (){
	
	$("#popUpDiv").on("click",function (){
		if($("#userId").val()  == ""){
			$("#userId").focus();	
		}else{
			$("#userPw").focus();	
		}
	});
	
	$("#duCheck").on("click",function(){
		duChkId();
	});
	
}

function saveUserInfo(){
	if(duChkY ==  "N"){
		alert("아이디 중복확인 ㄱㄱ");
	}else{
		var userId = $("#userId").val(); // ID
		var userPw = $("#userPw").val(); // PW
		var userNm = $("#userNm").val(); // nm
		
		var data = {
				"userId"  : userId,
				"userPw"  : userPw,
				"userNm" : userNm
		};
		$.ajax({
					type : "POST",
					data : data,
					dataType :  "json",
					contentType: 'application/json',
					url : "/saveUserInfo",
					success  : function(response){
						alert(response.count);
					}
					,error : function(){
						alert("ajax실패");
					}
		});
	}

}

function duChkId(){
	var duCheck = $("#duCheck").val();
	var data = {
			"duCheck" : duCheck
	};
		//id중복확인
		$.ajax({
				type : "POST",
				data : data,
				dataType :  "json",
				contentType: 'application/json',
				url : "/checkLogin",
				success  : function(response){
					alert(response.count);
					if(response.count ==  "true"){
						duChkY =  "Y"
					}else{
						duChkY =  "N"
						alert(response.count);
					}
				}
			,fail(){
				alert("api실패");
			}
		});
}
</script>

</html>

