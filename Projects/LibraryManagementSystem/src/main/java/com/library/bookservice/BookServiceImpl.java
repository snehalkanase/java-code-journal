package com.library.bookservice;

import com.library.models.Book;
import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO = new BookDAO();

    @Override
    public void addBook(String title, String author, Double price, int quantity) {
        bookDAO.addBook(title, author, price, quantity);
    }

    @Override
    public List<Book> searchBook(String key) {
        return bookDAO.searchBook(key);
    }

    @Override
    public void updateQuantity(int id, int quantity) {
        bookDAO.updateQuantity(id, quantity);
    }
}
