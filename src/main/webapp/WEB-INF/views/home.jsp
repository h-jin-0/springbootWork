<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<h1>home에 오신것을 환영합니다.</h1>
	<a href="/home/hello?id=ssar"> hello페이지로 이동-href</a>
	<br />
	<button id="hello-button">hello페이지로 이동-button</button>
	<br />
	<form>
		<input type="hidden" id="id" value="ssar" />
	</form>
	<button id="hello-button-form">hello 페이지 이동-form</button>
	<br />
	<form>
		<input type="hidden" id="username" value="love" />
		<input type="hidden" id="phone" value="0102222" />
	</form>
	<button id="hello-put-button">hello 페이지 이동-put</button>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		//delete 호출
		$('#hello-button').on('click', function() {
			let data = {
				id : 'ssar'
			}
			$.ajax({
				type : 'DELETE',
				url : '/home/hello',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json'
			}).done(function(result) {
				if (result.statusCode == 200) {
					alert("글이 삭제되었습니다.");
					location.href = '/home/hello';
				}
			}).fail(function(result) {
				alert('글 삭제가 실패하였습니다');
			});
		});
		//put 호출
		$('#hello-put-button').on('click', function() {
			let data = {
				username : $('#username').val(),
				phone : $('#phone').val()
			}

			$.ajax({
				type : 'PUT',
				url : '/home/hello',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json'
			}).done(function(result) {
				if (result.statusCode == 200) {
					alert("글이 등록되었습니다.");
					location.href = '/home/hello';
				}
			}).fail(function(result) {
				alert('글 삭제가 실패하였습니다');
			});
		});
		//post
		$('#hello-button-form').on('click', function() {
			let data = {
				id : $('#id').val()
			}
			$.ajax({
				type : 'POST',
				url : '/home/hello',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json'
			}).done(function(result) {
				if (result.statusCode == 200) {
					alert("글이 입력되었습니다.");
					location.href = '/home/hello';
				}
			}).fail(function(result) {
				alert('글 삭제가 실패하였습니다');
			});
		});
	</script>

</body>
</html>


