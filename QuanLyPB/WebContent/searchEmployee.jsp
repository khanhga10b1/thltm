<%@page import="java.util.List"%>
<%@page import="beans.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm kiếm nhân viên</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form action="searchEmployee" method="post">
		<input type="text" name="name" required="required" <%if(request.getParameter("name")!=null) {%> value="<%=request.getParameter("name")%>"<%} %> >
		<input class="submit" type="submit" value="tìm kiếm">
	</form>

<% 
List<Employee> employees =(List) request.getAttribute("employees");
if(employees!=null && !employees.isEmpty()){
 %>
  <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          	 <td>ID</td>
             <td>Tên nhân viên</td>
             <td>SĐT</td>
             <td>Ngày sinh</td>
             <td>Địa chi</td>
             <td>Mã phòng ban</td>
       </tr>
<% for(Employee e:employees){ %>
          <tr>
             <td><%=e.getId() %></td>
             <td><%=e.getName() %></td>
             <td><%=e.getPhone() %></td>
             <td><%=e.getDoB() %></td>
             <td><%=e.getAddress() %></td>
             <td><%=e.getDepId() %></td>
  
          </tr>
          <%} %>
    </table>
    <%} if(request.getParameter("name")!=null && employees.isEmpty()){%>không có kết quả phù hợp cho:<%=request.getParameter("name") %><%} %>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>