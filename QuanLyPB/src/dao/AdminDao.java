package dao;

import beans.Admin;

public interface AdminDao {
	Admin checkAdmin(String userName,String password);
}
