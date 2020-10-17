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
			String sql = "select * from nhanvien";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				LocalDate doB = LocalDate.parse(rs.getString(4));
				String address = rs.getString(5);
				int depId = rs.getInt(6);
				employees.add(new Employee(id, name, phone, doB, address, depId));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}

		return employees;
	}

	@Override
	public Employee getEmployee(int emid) {
		Employee employee = null;

		try {
			conn = ConnectDB.getConnection();
			String sql = "select * from nhanvien where manv =" + emid;
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				LocalDate doB = LocalDate.parse(rs.getString(4));
				String address = rs.getString(5);
				int depId = rs.getInt(6);
				employee = new Employee(id, name, phone, doB, address, depId);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		conn = ConnectDB.getConnection();
		String sql ="update nhanvien set tennv = '"+employee.getName()
		+"', SDT = '"+employee.getPhone()
		+"', NgaySinh = '"+employee.getDoB()
		+"', DiaChi = '"+employee.getAddress()
		+"', MaPb = "+employee.getDepId()
		+" where manv = "+employee.getId();
		try {
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		
	}
//	public static void main(String[] args) {
//	EmployeeDaoImpl a = new EmployeeDaoImpl();
//	Employee employee= a.getEmployee(3);
//	System.out.println(employee);
//}

	@Override
	public List<Employee> getEmployeeList(int id) {
		List<Employee> employees =new ArrayList<>();
		conn = ConnectDB.getConnection();
		String sql ="select * from nhanvien where mapb = "+id;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				int emid = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				LocalDate doB = LocalDate.parse(rs.getString(4));
				String address = rs.getString(5);
				int depId = rs.getInt(6);
				employees.add(new Employee(emid, name, phone, doB, address, depId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return employees;
	}

	@Override
	public void deleteEmployee(int id) {
		conn = ConnectDB.getConnection();
		String sql = "delete from nhanvien where manv ="+id;
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
	public void addEmployee(Employee employee) {
		conn = ConnectDB.getConnection();
		String sql ="insert into nhanvien(manv,tennv,sdt,ngaysinh,diachi,mapb) "
				+ "values(?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, employee.getId());
			pst.setString(2, employee.getName());
			pst.setString(3, employee.getPhone());
			pst.setString(4, employee.getDoB().toString());
			pst.setString(5, employee.getAddress());
			pst.setInt(6, employee.getDepId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
	}
}
