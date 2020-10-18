<%@page import="beans.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật nhân viên</title>
</head>
<body>
<% Employee employee =(Employee) request.getAttribute("employee");%>
<h1>edit</h1>
<jsp:include page="header.jsp"></jsp:include>
<form action="updateEmployee" method="post" >
	<input type="hidden" name="id" value="<%=employee.getId() %>" >
	<table>
		<tr>
			<td>Id: </td>
			<td ><%=employee.getId()%></td>
		</tr>
		<tr>
			<td>Tên: </td>
			<td><input type="text" name="name" value="<%=employee.getName() %>"  ></td>
		</tr>
		<tr>
			<td>SĐT: </td>
			<td><input type="text" name="phone" value="<%=employee.getPhone() %>"  ></td>
		</tr>
		<tr>
			<td>Ngày sinh: </td>
			<td><input type="date" name="doB" value="<%=employee.getDoB() %>"  ></td>
		</tr>
		<tr>
			<td>Địa chỉ: </td>
			<td><input type="text" name="address" value="<%=employee.getAddress() %>"  ></td>
		</tr>
		<tr>
			<td>Mã phòng ban: </td>
			<td><input type="text" name="depId" value="<%=employee.getDepId() %>"  ></td>
		</tr>
		<tr>
			<td><input type="submit" value="Xác nhận"></td>
			<td><a href="employeeListDep?id=<%=employee.getDepId()%>">Hủy</a> </td>
		</tr>
	</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>