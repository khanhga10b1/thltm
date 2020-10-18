<%@page import="beans.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm nhân viên</title>
</head>
<body>
<h1>ADD</h1>
<jsp:include page="header.jsp"></jsp:include>
<form action="addEmployee" method="post" name="addform" onsubmit="return checkform()">
	<input type="hidden" name="depId" value="<%=request.getParameter("id")%>">
	<table>
		<tr>
			<td>ID: </td>
			<td><input type="number" name="id" required="required"><span style="color: red;" id="errId"></span></td>
		</tr>
		<tr>
			<td>Tên: </td>
			<td><input type="text" name="name" required="required" ></td>
		</tr>
		<tr>
			<td>SĐT: </td>
			<td><input type="text" name="phone" pattern="[0-9]{3,15}" required="required" ></td>
		</tr>
		<tr>
			<td>Ngày Sinh: </td>
			<td><input type="date" name="doB" required="required" ></td>
		</tr>
		<tr>
			<td>Địa chỉ: </td>
			<td><input type="text" name="address" required="required"></td>
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
<%List<Employee> employees =(List) request.getAttribute("employees"); %>
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script>
    function checkform() {
          id = document.addform.id.value;
          <%for(Employee e:employees){%>
        if (id==<%=e.getId()%>) {
        	document.getElementById("errId").innerHTML = "id đã được sử dụng";
            return false;
        }
        <%}%>
        document.getElementById("errId").innerHTML = "";
        return true;
    }
</script>
</html>
