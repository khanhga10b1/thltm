package service;

import java.util.List;

import beans.Department;

public interface DepartmentService {
	List<Department> getAllDepartments();
	void addDepartment(Department department);
	void deleteDepartment(int id);
	Department getDepartment(int id);
	void updateDepartment(Department department);
}
