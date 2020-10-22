<%@page import="beans.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<style type="text/css">
.header{
    background-color:#1abc9c;

}

.header ul{
    margin:0;
    padding:0;
    list-style-type:none;
}

.header li{
    display:inline-block;
}
.header li:hover{
	background-color: orange;
}

.header li a{
    display:inline-block;
    text-decoration:none;
    color:white;
    padding:14px 16px;
}
table, th, td{
    border:1px solid #868585;
}
table{
    border-collapse:collapse;
}
table tr:nth-child(odd){
    background-color:#eee;
}
table tr:nth-child(even){
    background-color:white;
}
table tr:nth-child(1){
    background-color:skyblue;
}
table a,.addEmployee,.submit {
    background-color: gray;
    color: white;
    padding: 10px 15px;
    text-align: center; 
    text-decoration: none;
    display: inline-block;
    border-radius: 10px;
    border: none;
}

table a:hover,.addEmployee:hover,.addEmployee:hover,.submit:hover {
    background-color: red;
}


</style>
<div>
<nav class="header">
	<ul>
		<li><a href="home">Home</a></li>
		<li><a href="departmentList">Danh sách phòng ban</a></li>
		<li><a href="addDepartment">Thêm Phòng ban</a></li>
		<li><a href="updateAndDeleteDep">Sửa và xóa phòng ban</a></li>
		<li><a href="searchEmployee">Tìm kiếm nhân viên</a></li>
		<% if(session.getAttribute("admin")==null){ %> 
		<li><a href="login">Đăng nhập</a></li>
		 <%} else{Admin admin =(Admin)session.getAttribute("admin"); %>
		 <li><a href="logout">Đăng xuất</a></li>
		 <li>Hello: <%=admin.getUserName() %><%} %> </li>
	</ul>
</nav>
</div>