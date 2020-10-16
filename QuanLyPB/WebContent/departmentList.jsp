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
<% List<Department> departments =(List) request.getAttribute("departments");%>
	<table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          	 <td>ID</td>
             <td>Tên phòng ban </td>
             <td>Xem danh sách</td>
       </tr>
       <%for(Department d:departments){ %>
       <tr>
          	 <td><%=d.getId() %></td>
           	 <td><%=d.getName() %></td>
             <td><a href="employeeListDep?id=<%=d.getId()%>">Xem</a></td>
       </tr>
       <%} %>
       </table>
</body>
</html>