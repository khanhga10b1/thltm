package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@WebServlet(urlPatterns = { "/searchEmployee" })
public class SearchEmployeeServlet extends HttpServlet {
	private EmployeeService service;
	private static final long serialVersionUID = 1L;
	
	public SearchEmployeeServlet() {
		service = new EmployeeServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchEmployee.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		List<Employee> employees = service.searchEmployee(name);
		request.setAttribute("employees",employees);
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchEmployee.jsp");
		dispatcher.forward(request, response);
	}

}
