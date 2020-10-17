package service;

import java.util.List;

import beans.Department;
import dao.DepartmentDao;
import dao.DepartmentImpl;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao dao = new DepartmentImpl();
	@Override
	public List<Department> getAllDepartments() {
		return dao.getAllDepartments();
	}
	@Override
	public void addDepartment(Department department) {
			dao.addDepartment(department);
	}
	@Override
	public void deleteDepartment(int id) {
		dao.deleteDepartment(id);
	}
	@Override
	public Department getDepartment(int id) {
		return dao.getDepartment(id);
	}
	@Override
	public void updateDepartment(Department department) {
		dao.updateDepartment(department);
	}

}
