<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ADD</h1>
<jsp:include page="header.jsp"></jsp:include>
<form action="addEmployee" method="post">
	<input type="hidden" name="depId" value="<%=request.getParameter("id")%>">
	<table>
		<tr>
			<td>ID: </td>
			<td><input type="text" name="id" ></td>
		</tr>
		<tr>
			<td>Tên: </td>
			<td><input type="text" name="name" ></td>
		</tr>
		<tr>
			<td>SĐT: </td>
			<td><input type="text" name="phone" ></td>
		</tr>
		<tr>
			<td>Ngày Sinh: </td>
			<td><input type="date" name="doB" ></td>
		</tr>
		<tr>
			<td>Địa chỉ: </td>
			<td><input type="text" name="address" ></td>
		</tr>
		<tr>
			<td>Mã phòng ban: </td>
			<td><%=request.getParameter("id") %></td>
		</tr>
		<tr>
			<td><input type="submit" value="Xác nhận"></td>
			<td><a href="employeeListDep?id=<%=request.getParameter("id")%>">Hủy</a> </td>
		</tr>
	</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>