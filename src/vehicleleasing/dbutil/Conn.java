package vehicleleasing.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conn {
	public static Connection getConnection() {
		Connection con=null;
		ResourceBundle rs=ResourceBundle.getBundle("db");
		String driver=rs.getString("driverName");
		String url=rs.getString("url");
		String pwd=rs.getString("password");
		String user=rs.getString("user");
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			return con;
		}catch( ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}


