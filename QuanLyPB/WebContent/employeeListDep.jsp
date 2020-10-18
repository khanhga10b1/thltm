<%@page import="beans.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhân viên</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<% 
List<Employee> employees =(List) request.getAttribute("employees");
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
             <td><%=e.getDepId() %></td>
             <td>
                <a href="updateEmployee?id=<%=e.getId()%>">Edit</a>
             </td>
             <td>
                <a href="deleteEmployee?id=<%=e.getId()%>&depId=<%=e.getDepId() %>">Delete</a>
             </td>
          </tr>
          <%} %>
    </table>
    <a href="addEmployee?id=<%=request.getParameter("id")%>">Thêm nhân viên</a>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>