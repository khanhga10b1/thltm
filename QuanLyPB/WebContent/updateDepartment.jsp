<%@page import="beans.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%Department department =(Department) request.getAttribute("department"); %>
	<form action="updateDepartment" method="post">
	<input type="hidden" name="id" value="<%=department.getId()%>">
	<table>
		<tr>
			<td>Id: </td>
			<td ><%=department.getId()%></td>
		</tr>
		<tr>
		<tr>
			<td>Tên phòng ban: </td>
			<td><input type="text" name="name" value="<%=department.getName() %>"  ></td>
		</tr>
		<tr>
		<tr>
			<td><input type="submit" value="Xác nhận"></td>
			<td><a href="updateAndDeleteDep">Hủy</a> </td>
		</tr>
		<tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>