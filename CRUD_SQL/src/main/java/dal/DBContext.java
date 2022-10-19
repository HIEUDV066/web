package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	protected Connection connection;
  
    public DBContext() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/categories", "root", "hieudaica");
	    } catch (ClassNotFoundException | SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
}
