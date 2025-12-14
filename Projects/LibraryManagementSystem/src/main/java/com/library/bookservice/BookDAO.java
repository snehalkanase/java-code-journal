package com.library.bookservice;

import com.library.common.DatabaseConnection;
import com.library.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public void addBook(String title, String author, Double price, int quantity) {
        String sql = "INSERT INTO books (title, author, price, quantity) VALUES (?, ?, ?, ?)";
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.executeUpdate();

            ps.close();
            DatabaseConnection.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public List<Book> searchBook(String key){
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, "%"+ key +"%");
            ps.setString(2, "%"+ key +"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
            rs.close();
            ps.close();
            DatabaseConnection.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void updateQuantity(int id, int quantity){
        String sql = "UPDATE books SET quantity = quantity + ? WHERE id = ?";
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            DatabaseConnection.closeConnection(con);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
