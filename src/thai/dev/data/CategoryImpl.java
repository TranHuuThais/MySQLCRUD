package thai.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryImpl {

	public static void select(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORIES";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String thumbnail = rs.getString("thumbnail");
				System.out.format("id:/d - name:%s - thumbnail:%s", id, name, thumbnail).println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Delete(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM CATEGORIES WHERE ID=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 2);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Update(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "UPDATE CATEGORIES SET NAME=? ,THUMBNAIL=? WHERE ID=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "ao nU");
			stmt.setString(2, "http://images.com/aoNU.jpg");
			stmt.setInt(3, 1);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Insert(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CATEGORIES(NAME,THUMBNAIL) VALUES (?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "");
			stmt.setString(2, "http://images.com/aodai.jpg");

			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
