package com.library.bookingservice;

import com.library.common.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookingDAO {
    public void checkout(int sid, int bid){
        String insertSQL = "INSERT INTO booking_details(student_id, book_id, checkout_date) VALUES (?,?, now())";
        String upadteSQL = "UPDATE books SET quantity= quantity - 1 WHERE id= ?";

        try(Connection con = DatabaseConnection.getConnection()){
            con.setAutoCommit(false);
            try(PreparedStatement ps1 = con.prepareStatement(insertSQL);
                PreparedStatement ps2 = con.prepareStatement(upadteSQL)){

                ps1.setInt(1, sid);
                ps1.setInt(2, bid);
                ps1.executeUpdate();

                ps2.setInt(1, bid);
                ps2.executeUpdate();

                con.commit();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
