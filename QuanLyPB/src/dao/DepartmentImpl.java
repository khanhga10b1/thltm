package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import beans.Department;
import beans.Employee;

public class DepartmentImpl implements DepartmentDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;

	@Override
	public List<Department> getAllDepartments() {
		return mockData();
	}

	private List<Department> mockData() {
		List<Department> departments = new ArrayList<>();
		try {
			conn = ConnectDB.getConnection();
			String sql = "select * from phongban";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				departments.add(new Department(id, name));

			}
			ConnectDB.close(conn);
		} catch (SQLException e) {
		}

		return departments;
	}

	@Override
	public void addDepartment(Department department) {
		conn = ConnectDB.getConnection();
		String sql = "insert into phongban(mapb,tenpb) values(" + department.getId() + ",'" + department.getName()
				+ "')";
		try {
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
	}

	@Override
	public void deleteDepartment(int id) {
		conn = ConnectDB.getConnection();
		String sql = "delete from phongban where mapb="+id;
		try {
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		
	}

	@Override
	public void updateDepartment(Department department) {
		conn=ConnectDB.getConnection();
		String sql = "update phongban set tenpb ='"+department.getName()+"' where mapb="+department.getId();
		try {
			pst=conn.prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		
	}

	@Override
	public Department getDepartment(int id) {
		Department department = null;
		conn = ConnectDB.getConnection();
		String sql ="select * from phongban where mapb="+id;
		try {
			pst = conn.prepareStatement(sql);
			rs= pst.executeQuery();
			while(rs.next()) {
				int depId = rs.getInt(1);
				String name = rs.getString(2);
				department = new Department(depId, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return department;
	}

}
