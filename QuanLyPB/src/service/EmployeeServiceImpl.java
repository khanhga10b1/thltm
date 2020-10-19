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
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}
	@Override
	public void addEmployee(Employee employee) {
		dao.addEmployee(employee);
	}
	@Override
	public List<Employee> searchEmployee(String name) {
		return dao.searchEmployee(name);
	}
	
}
