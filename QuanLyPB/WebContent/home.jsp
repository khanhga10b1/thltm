<%@page import="service.EmployeeServiceImpl"%>
<%@page import="service.EmployeeService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Employee"%>
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
<div style="padding: 5px;">
<a href="">Home</a>
   |
   <a href="">Thêm </a>
   |
   <a href="">Sửa</a>
   |
   <a href="">Xóa</a>
</div>  
<% 
List<Employee> employees =(List) request.getAttribute("list");
 %>

  <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <td>ID</td>
             <td>Tên nhân viên</td>
             <td>SĐT</td>
             <td>Ngày sinh</td>
             <td>Địa chi</td>
             <td>Mã phòng ban</td>
             <th>Edit</th>
         	 <th>Delete</th>
       </tr>
<% for(Employee e:employees){ %>
          <tr>
             <td><%=e.getId() %></td>
             <td><%=e.getName() %></td>
             <td><%=e.getPhone() %></td>
             <td><%=e.getDoB() %></td>
             <td><%=e.getAddress() %></td>
             <td><%=e.getId() %></td>
             <td>
                <a href="">Edit</a>
             </td>
             <td>
                <a href="">Delete</a>
             </td>
          </tr>
          <%} %>
    </table>
</body>
</html>