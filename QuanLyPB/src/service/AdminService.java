package service;

import beans.Admin;

public interface AdminService {
	Admin checkAdmin(String userName,String password);
}
