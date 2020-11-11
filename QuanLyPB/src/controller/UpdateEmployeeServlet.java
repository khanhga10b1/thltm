package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@WebServlet(urlPatterns = { "/updateEmployee" })
public class UpdateEmployeeServlet extends HttpServlet {
	private EmployeeService service;
	
	public UpdateEmployeeServlet() {
		service = new EmployeeServiceImpl();
	}
	
	private static final long serialVersionUID = 1L;

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
		Employee employee = service.getEmployee(id);

		request.setAttribute("employee", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployee.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		LocalDate doB = LocalDate.parse(request.getParameter("doB"));
		String address = request.getParameter("address");
		int depId = Integer.parseInt(request.getParameter("depId"));
		service.updateEmployee(new Employee(id, name, phone, doB, address, depId));
		response.sendRedirect("employeeListDep?id="+depId);
	}
}
