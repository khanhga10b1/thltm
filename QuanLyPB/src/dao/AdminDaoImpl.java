package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Admin;
import utils.ConnectDB;
import utils.SqlUltils;

public class AdminDaoImpl implements AdminDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;

	@Override
	public Admin checkAdmin(String userName, String password) {
		Admin admin = null;
		conn = ConnectDB.getConnection();
		String sql = "select * from ad where taikhoan = ? and matkhau =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String pass = rs.getString(3);
				admin = new Admin(id, name, pass);
				admin.setUserName(name);
				admin.setPassword(pass);

				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUltils.close(rs,pst,conn);
		}

		return admin;
	}

}
