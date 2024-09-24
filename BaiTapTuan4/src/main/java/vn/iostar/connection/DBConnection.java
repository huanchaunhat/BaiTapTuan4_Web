package vn.iostar.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/dangnhap_dangki";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "Nhathuan160704!";
	private static Connection connection;

    // Phương thức để lấy kết nối
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        }
        return connection;
    }
    
    public static void main(String[] args) {
    	try {
    		System.out.println(new DBConnection().getConnection());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
