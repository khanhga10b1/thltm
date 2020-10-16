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
@WebServlet(urlPatterns = {"/employeeListDep"})
public class EmployeeListDepServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	EmployeeService service = new EmployeeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect("home");
			return;
		}
		List<Employee> employees = service.getEmployeeList(id);
		request.setAttribute("employees", employees);
		RequestDispatcher dispatcher=request.getRequestDispatcher("employeeListDep.jsp");
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
