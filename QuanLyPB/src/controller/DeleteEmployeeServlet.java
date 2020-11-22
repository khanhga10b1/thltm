package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
import service.EmployeeServiceImpl;
@WebServlet(urlPatterns = {"/deleteEmployee"})
public class DeleteEmployeeServlet extends HttpServlet {
	private final EmployeeService service;
	
	public DeleteEmployeeServlet() {
		service = new EmployeeServiceImpl();
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		int depId =0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			depId = Integer.parseInt(request.getParameter("depId"));
		} catch (Exception e) {
			response.sendRedirect("home");
			return;
		}
		service.deleteEmployee(id);
		response.sendRedirect("employeeListDep?id="+depId);
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
