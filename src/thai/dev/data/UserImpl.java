package thai.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl {


    public static void select(Connection conn, int userId) {
        String sql = "SELECT * FROM `USER` WHERE ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId); 
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                String role = rs.getString("ROLE");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                System.out.println("Role: " + role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void insert(Connection conn, String email, String password, String role) {
        String sql = "INSERT INTO `USER` (ID,EMAIL, PASSWORD, ROLE) VALUES (NULL,?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, role);
            stmt.execute();
            System.out.println("User inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error while inserting user: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void delete(Connection conn, int userId) {
        String sql = "DELETE FROM `USER` WHERE ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId); 
            stmt.executeUpdate();
            System.out.println("Delete successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void update(Connection conn, int userId, String email, String password, String role) {
        String sql = "UPDATE `USER` SET EMAIL = ?, PASSWORD = ?, ROLE = ? WHERE ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email); 
            stmt.setString(2, password); 
            stmt.setString(3, role); 
            stmt.setInt(4, userId); 
            stmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
	