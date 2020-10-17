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
<jsp:include page="header.jsp"></jsp:include>
<% List<Department> departments =(List) request.getAttribute("departments");%>
	<table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          	 <td>ID</td>
             <td>Tên phòng ban </td>
             <td>Xóa</td>
             <td>Sửa</td>
       </tr>
       <%for(Department d:departments){ %>
       <tr>
          	 <td><%=d.getId() %></td>
           	 <td><%=d.getName() %></td>
             <td><a href="deleteDepartment?id=<%=d.getId()%>">Xóa</a></td>
             <td><a href="updateDepartment?id=<%=d.getId()%>">Sửa</a></td>
       </tr>
       <%} %>
       </table>
       <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>