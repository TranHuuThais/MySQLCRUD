package thai.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductImpl {

	public static void select(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORIES";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				Double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				String thumbnail = rs.getString("thumbnail");
				int view = rs.getInt("view");
				int category_Id = rs.getInt("category_Id");
				System.out.printf("name" + name, "description" + description, "price" + price, "quantity" + quantity,
						"thumbnail" + thumbnail, "view" + view, "categoryId" + category_Id);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Insert(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO PRODUCTS(NAME, DESCRIPTION, PRICE, QUANTITY, THUMBNAIL, VIEW, CATEGORY_ID) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "T_bag");
			stmt.setString(2, "New T_bag");
			stmt.setDouble(3, 17);
			stmt.setInt(4, 5);
			stmt.setString(5, "./assets/img/products/f5.jpg");
			stmt.setInt(6, 10);
			stmt.setInt(7, 1);

			stmt.execute();
			System.out.println("INSERT successful!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Delete(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM PRODUCTS WHERE ID=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 11);
			stmt.executeUpdate();
			System.out.println("DELETE successful!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Update(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "UPDATE PRODUCTS SET NAME=? ,DESCRIPTION=?,PRICE=?,QUANTITY=?,THUMBNAIL=?,VIEW=?,CATEGORY_ID=? WHERE ID=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "T_bag");
			stmt.setString(2, "New T_bag");
			stmt.setDouble(3, 17);
			stmt.setInt(4, 5);
			stmt.setString(5, "./assets/img/products/f5.jpg");
			stmt.setInt(6, 10);
			stmt.setInt(7, 1);
			stmt.execute();
			System.out.println("Update successful!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
