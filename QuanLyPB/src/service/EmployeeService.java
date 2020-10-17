package service;

import java.util.List;

import beans.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee getEmployee(int id);
	void updateEmployee(Employee employee);
	List<Employee> getEmployeeList(int id);
	void deleteEmployee(int id);
	void addEmployee(Employee employee);
}
