package service;

import java.util.List;

import beans.Department;
import dao.DepartmentDao;
import dao.DepartmentImpl;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao dao = new DepartmentImpl();
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return dao.getAllDepartments();
	}

}
