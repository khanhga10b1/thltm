<%@page import="beans.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm phòng ban</title>
</head>
<body>
<h1>ADD</h1>
<jsp:include page="header.jsp"></jsp:include>
<form action="addDepartment" method="post" name="addform" onsubmit="return checkform()">
	<table>
		<tr>
			<td>ID phòng ban: </td>
			<td><input type="number" name="id" required="required"><span style="color: red;" id="errId"></span></td>
		</tr>
		<tr>
			<td>Tên phòng ban: </td>
			<td><input type="text" name="name" required="required"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Xác nhận"></td>
			<td><a href="home">Hủy</a> </td>
		</tr>
	</table>
</form>
<%List<Department> departments =(List) request.getAttribute("departments"); %>
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script>
    function checkform() {
          id = document.addform.id.value;
          <%for(Department d:departments){%>
        if (id==<%=d.getId()%>) {
        	document.getElementById("errId").innerHTML = "id đã được sử dụng";
            return false;
        }
        <%}%>
        document.getElementById("errId").innerHTML = "";
        return true;
    }
</script>
</html>