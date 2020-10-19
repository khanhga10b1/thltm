<%@page import="beans.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
    
<div style="padding: 5px;">
<a href="home">Home</a>
   |
   <a href="departmentList">Danh sách phòng ban</a>
	|
	<a href="addDepartment">Thêm Phòng ban</a>
	|
	<a href="updateAndDeleteDep">Sửa và xóa phòng ban</a>
	|
	<a href="searchEmployee">Tìm kiếm nhân viên</a>
	|
	<% if(session.getAttribute("admin")==null){ %> <a href="login">Đăng nhập</a><%} else{Admin admin =(Admin)session.getAttribute("admin"); %>
	<a href="logout">Đăng xuất</a> Hello: <%=admin.getUserName() %><%} %>
</div>