package dao;

import java.util.List;

import beans.Department;

public interface DepartmentDao {
	List<Department> getAllDepartments();
	void addDepartment(Department department);
	void deleteDepartment(int id);
	void updateDepartment(Department department);
	Department getDepartment(int id);
	}
