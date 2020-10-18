<%@page import="beans.Department"%>
<%@page import="java.util.List"%>
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
<form action="addDepartment" method="post">
	<table>
		<tr>
			<td>ID phòng ban: </td>
			<td><input type="text" name="id" ></td>
		</tr>
		<tr>
			<td>Tên phòng ban: </td>
			<td><input type="text" name="name" ></td>
		</tr>
		<tr>
			<td><input type="submit" value="Xác nhận"></td>
			<td><a href="home">Hủy</a> </td>
		</tr>
	</table>
</form>
<%List<Department> departments =(List) request.getAttribute("departments"); %>
<div style="color: #FF0000;">
Các id đã dùng:<%for(Department d:departments){ %><%=d.getId()+" " %><%} %>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>