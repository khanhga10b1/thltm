package controller;

import java.io.IOException;
import java.time.LocalDate;
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

@WebServlet(urlPatterns = { "/addEmployee" })
public class AddEmployeeServlet extends HttpServlet {
	private final EmployeeService service;
	public AddEmployeeServlet() {
		service = new EmployeeServiceImpl();
	}
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> employees = service.getAllEmployees();
		request.setAttribute("employees",employees);
		RequestDispatcher dispatcher =request.getRequestDispatcher("addEmployee.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int id = 0;
		int depId=0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			depId=Integer.parseInt(request.getParameter("depId"));
		} catch (Exception e) {
			response.sendRedirect("home");
			return;
		}
		System.out.println("dep: "+depId);
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		LocalDate doB = LocalDate.parse(request.getParameter("doB"));
		String address = request.getParameter("address");
		service.addEmployee(new Employee(id, name, phone, doB, address, depId));
		response.sendRedirect("employeeListDep?id="+depId);

	}
}
