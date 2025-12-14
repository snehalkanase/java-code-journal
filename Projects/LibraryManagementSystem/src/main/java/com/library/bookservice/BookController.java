package com.library.bookservice;

import com.library.common.ConsoleUtils;
import com.library.models.Book;

import java.util.List;

public class BookController {
    private final BookServiceImpl bookServiceImpl = new BookServiceImpl();

    public void addBook() {
        bookServiceImpl.addBook(
                ConsoleUtils.readString("Title: "),
                ConsoleUtils.readString("Author: "),
                Double.parseDouble(ConsoleUtils.readString("Price: ")),
                ConsoleUtils.readInt("Quantity: ")
        );
        System.out.println("Book added successfully");
    }
    public void searchBook() {
        for(Book b : bookServiceImpl.searchBook(ConsoleUtils.readString("Search Book: "))) {
            System.out.println(b.id+" | "+b.title+" | "+b.author+ " | "  + "Qty:"+b.quantity);
        }
    }
    public void updateQuantity(){
        bookServiceImpl.updateQuantity(
                ConsoleUtils.readInt("Book Id: "),
                ConsoleUtils.readInt("Quantity: ")
        );
        System.out.println("Book quantity updated successfully");
    }

}
