package service;

import java.util.List;

import beans.Employee;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao dao = new EmployeeDaoImpl(); 
	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}
	
}
