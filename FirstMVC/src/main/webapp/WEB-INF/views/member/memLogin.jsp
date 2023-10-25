<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login 입력 페이지</title>
</head>
<body>
	<h2>일반 테스트</h2>
	<form action="memLogin" method="post"><br>
		ID : <input type="text" name="memId"><br><br>
		PW : <input type="password" name="memPw">
		<input type="submit" value="로그인">
	</form>
	<hr>
	<h2>ModelAndView 테스트</h2>
	<form action="memLoginModelAndView" method="post"><br>
		ID : <input type="text" name="memId"><br><br>
		PW : <input type="password" name="memPw">
		<input type="submit" value="로그인">
	</form>
</body>
</html> 