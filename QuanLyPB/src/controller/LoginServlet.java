package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Admin;
import service.AdminService;
import service.AdminServiceImpl;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private AdminService service;
	
	public LoginServlet() {
		service = new AdminServiceImpl();
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		Admin admin = service.checkAdmin(userName, password);
		
		if(admin == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			
			String url = (String) session.getAttribute("url");
			System.out.println(url);
			
			if(url==null) {
				response.sendRedirect("home");
			}else {
				response.sendRedirect(url);
			}
		}
		
	}

}
