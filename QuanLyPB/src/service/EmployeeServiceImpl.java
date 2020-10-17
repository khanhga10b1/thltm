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
	@Override
	public Employee getEmployee(int id) {
		return dao.getEmployee(id);
	}
	@Override
	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}
	@Override
	public List<Employee> getEmployeeList(int id) {
		return dao.getEmployeeList(id);
	}
	@Override
	public void deletaEmployee(int id) {
		dao.deletaEmployee(id);
	}
	
}
