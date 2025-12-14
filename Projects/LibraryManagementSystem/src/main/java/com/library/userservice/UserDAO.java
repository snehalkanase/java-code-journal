package com.library.userservice;

import java.sql.*;
import com.library.common.DatabaseConnection;
import com.library.models.User;

public class UserDAO {
    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new User(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("username"),
                        rs.getString("role"),
                        rs.getString("reg_no")
                );
            }
            rs.close();
            ps.close();
            DatabaseConnection.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void register(String fullName,String username, String password, String role, String reg_no){
        String sql = "INSERT INTO users(full_name, username, password, role, reg_no) VALUES (?, ?, ?, ?, ?)";
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, fullName);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, role);
            ps.setString(5, reg_no);

            ps.executeUpdate();

            ps.close();
            DatabaseConnection.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
