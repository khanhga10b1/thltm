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
			String sql ="select * from nhanvien";
			pst =conn.prepareStatement(sql);
			rs =pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				departments.add(new Department(id, name));
				
			}
			ConnectDB.close(conn);
		} catch (SQLException e) {
		}
		
		return departments;
	}

}
