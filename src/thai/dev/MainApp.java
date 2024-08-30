package thai.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import thai.dev.data.CategoryImpl;
import thai.dev.data.OrderImpl;
import thai.dev.data.ProductImpl;
import thai.dev.data.UserImpl;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = getConnection();
//		CategoryImpl.Insert(conn);
//		CategoryImpl.Update(conn);
//		CategoryImpl.Delete(conn);
//		CategoryImpl.select(conn);
		//ProductImpl.Insert(conn);
		//ProductImpl.Delete(conn);
		//OrderImpl.insert(conn);
		//OrderImpl.Delete(conn);
		//UserImpl.insert(conn, "Thai@gmail.com", "123", "1");
		UserImpl.delete(conn, 3);
	}

	
	private static Connection getConnection() {
		// TODO Auto-generated method stub
		final String DB_URL = "jdbc:mysql://localhost:3306/shop";
		final String USER = "root";
		final String PASS = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
