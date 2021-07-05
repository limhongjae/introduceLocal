<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
	<title>로그인</title>
</head>
<body>
		<form id = "loginFrm"  method="post" action = "/checkLogin">
				<input type = "text" id = "userId"  name = "userId" placeholder="아이디(ID)"/> <br>
				<input type = "text"  id = "userPw" name = "userPw" placeholder="비밀번호(PW)" style = "margin-top:  5px;"/>
		</form>
		
		<div id = "btnDiv" style = "margin-top:  5px; ">
			<button id = "singUp">회원가입</button>
			<button id = "btnLogin">로그인</button>
		</div>
		
</body>
<script type="text/javascript"  charset="utf-8">

$("document").ready(function (){
	setEventListner();	
});

function setEventListner(){
	$("#singUp").on("click",function(){
		popupOpen();
	});
	
	$("#btnLogin").on("click",function(){
		loginCheck();
	});
}

function loginCheck(){
	alert("구현중");
/* 	console.log(JSON.stringify({
        "userId" : loginId
  	})); */
}


function signUp(){
	popupOpen();
	//필수값 확인 controller 호출 : "checkLogin"  
/*  	$.ajax({
		type : "POST",
		data : JSON.stringify({"userId"  : loginId}),
		dataType :  "json",
		contentType: 'application/json',
		url : "/checkLogin",
		success  : function(response){
			alert(response.msg);
		}
	}); */

}
</script>

</html>

