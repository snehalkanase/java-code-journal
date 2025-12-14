package com.library.app;

import java.sql.Connection;

import com.library.bookingservice.BookingController;
import com.library.bookservice.BookController;
import com.library.common.ConsoleUtils;
import com.library.common.DatabaseConnection;
import com.library.models.User;
import com.library.userservice.UserController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        BookController bookController = new BookController();
        BookingController bookingController = new BookingController();

        User user = userController.login();

         while(user == null) {
            System.out.println("Invalid username or password");
            user = userController.login();
        }
        if(user.getRole().equals("ADMIN")){
            adminMenu(userController,bookController);
        }else {
            studentMenu(bookController, bookingController, user.getId());
        }
    }
    public static void adminMenu(UserController userController, BookController bookController){
        while(true){
            System.out.println("Welcome Administrator");
            System.out.println("Please enter your choice");
            System.out.println("1. Add User");
            System.out.println("2. Add Book");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book Quantity");
            int choice = ConsoleUtils.readInt("Choice: ");
            switch (choice){
                case 1 -> userController.register();
                case 2 -> bookController.addBook();
                case 3 -> bookController.searchBook();
                case 4 -> bookController.updateQuantity();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void studentMenu(BookController bookController, BookingController bookingController, int userId){
        while(true){
            System.out.println("Welcome Student");
            System.out.println("Please enter your choice");
            System.out.println("1. Search Book");
            System.out.println("2. Checkout Book");
            switch (ConsoleUtils.readInt("Choice: ")){
                case 1 -> bookController.searchBook();
                case 2 -> bookingController.checkout(userId);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}