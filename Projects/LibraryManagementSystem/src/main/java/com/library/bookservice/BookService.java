package com.library.bookservice;

import com.library.models.Book;

import java.util.List;

public interface BookService {
    void addBook(String title, String author, Double price, int quantity);
    List<Book> searchBook(String key);
    void updateQuantity(int id, int quantity);
}
