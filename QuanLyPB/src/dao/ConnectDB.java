package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static String url ="jdbc:mysql://localhost:3306/quanlypb";
	private static String user="root";
	private static String password = "123456";
	private static Connection conn = null;

	public static  Connection getConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("kết nối thành công");
		} catch (Exception e) {
			System.out.println("Chưa được");
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			conn.close();
			System.out.println("đã đóng kết nối.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("đóng kết nối thất bại");
		}
	}
}
