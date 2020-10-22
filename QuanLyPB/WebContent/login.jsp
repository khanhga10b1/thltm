<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="login" method="post" style="margin: 100px auto; width: 300px;">
	<h1>Đăng nhập</h1>
	<table>
		<tr>
			<td>Tài khoản: </td>
			<td><input type="text" name="userName" required="required"></td>
		</tr>
		<tr>
			<td>mật khẩu: </td>
			<td><input type="password" name="password" required="required"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Đăng nhập"></td>
			<td><a href="home">Hủy</a> </td>
		</tr>
	</table>
	</form>
</body>
</html>