package com.library.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static final String url = "jdbc:mysql://localhost:3306/library_db";
    private static final String username = "snehalkanase";
    private static final String password = "Snehal@90";

    // get a new connection
    public static Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url,username,password );
        }catch (SQLException e){
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
        return connection;
    }
    // close the connection
    public static void closeConnection(Connection connection){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch (SQLException e){
            System.out.println("Failed to close database connection!");
            e.printStackTrace();
        }
    }
}
