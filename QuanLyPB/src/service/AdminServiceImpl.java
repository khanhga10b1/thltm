package service;

import beans.Admin;
import dao.AdminDao;
import dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService {
	private final AdminDao dao;
	public AdminServiceImpl() {
		dao = new AdminDaoImpl();
	}
	@Override
	public Admin checkAdmin(String userName, String password) {
		return dao.checkAdmin(userName, password);
	}

}
