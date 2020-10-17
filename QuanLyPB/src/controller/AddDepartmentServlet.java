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

@WebServlet(urlPatterns = { "/addDepartment" })
public class AddDepartmentServlet extends HttpServlet {
	DepartmentService service = new DepartmentServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			RequestDispatcher dispatcher =request.getRequestDispatcher("addDepartment.jsp");
			dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect("home");
			return;
		}
		String name = request.getParameter("name");
		service.addDepartment(new Department(id, name));
		response.sendRedirect("departmentList");
	}
}
