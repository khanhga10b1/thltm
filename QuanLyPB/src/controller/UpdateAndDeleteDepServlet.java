package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Department;
import service.DepartmentService;
import service.DepartmentServiceImpl;

@WebServlet(urlPatterns = { "/updateAndDeleteDep" })
public class UpdateAndDeleteDepServlet extends HttpServlet {
	DepartmentService service= new DepartmentServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Department> departments = service.getAllDepartments();
		request.setAttribute("departments", departments);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateAndDeleteDep.jsp");
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
