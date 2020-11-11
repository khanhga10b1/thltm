package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Department;
import service.DepartmentService;
import service.DepartmentServiceImpl;

@WebServlet(urlPatterns = {"/updateDepartment"})
public class UpdateDepartmentServlet extends HttpServlet {
	private DepartmentService service;
	
	public UpdateDepartmentServlet() {
		service =new DepartmentServiceImpl();
	}
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect("home");
			return;
		}
		Department department = service.getDepartment(id);
		request.setAttribute("department", department);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateDepartment.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int id =Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		service.updateDepartment(new Department(id, name));
		response.sendRedirect("updateAndDeleteDep");
	}

}
