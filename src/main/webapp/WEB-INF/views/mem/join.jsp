<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입  페이지</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>username</th>
			<th>password</th>
			<th>email</th>
		</tr>

		<tr>
			<td><input id="username" type="text"/></td>
			<td><input id="password" type="password" /></td>
			<td><input id="email" type="email"  /></td>
		</tr>

	</table>
	<button id="mem_join_Proc">가입하기</button>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		$('#mem_join_Proc').on('click', function() {
			let data = {
				username:$('#username').val(),
				password : $('#password').val(),
				email : $('#email').val(),
				
			}

			$.ajax({
				type : 'POST',
				url : '/mem/api/join',
				data : JSON.stringify(data), 
				contentType : 'application/json; charset=utf-8',
				dataType : 'text'
			}).done(function(result) {

				if(result === 'ok'){
					alert("회원 가입 성공");
					location.href = '/mem';
				}else{
					alert('회원 가입 실패');}

			}).fail(function(result) {
				alert('서버오류');
			});
		});


		
	</script>
</body>
</html>