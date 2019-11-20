<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/File"enctype="multipart/form-data">
<!--  메소드가 반듯이 post 이여야 한다  -->
	파일 : <input type="File" name ="f1"><br>
	아이디 : <input type="text" name ="id"><br>
	<button>파일 전송</button>
</form>
</body>
</html>