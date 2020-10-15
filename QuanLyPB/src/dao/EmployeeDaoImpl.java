package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;

	@Override
	public List<Employee> getAllEmployees() {
		
		return mockData();
	}
	private List<Employee> mockData() {
		List<Employee> employees = new ArrayList<>();
		try {
			conn = ConnectDB.getConnection();
			String sql ="select * from nhanvien";
			pst =conn.prepareStatement(sql);
			rs =pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				LocalDate doB = LocalDate.parse(rs.getString(4));
				String address = rs.getString(5);
				int depId = rs.getInt(6);
				employees.add(new Employee(id, name, phone, doB, address, depId));
				
			}
			ConnectDB.close(conn);
		} catch (SQLException e) {
		}
		
		return employees;
	}
//	public static void main(String[] args) {
//		EmployeeDaoImpl xxx = new EmployeeDaoImpl();
//		List<Employee> abc =xxx.getAllEmployees();
//		abc.forEach(System.out::println);
//	}
}
