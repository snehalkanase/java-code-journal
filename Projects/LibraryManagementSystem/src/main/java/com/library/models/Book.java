package com.library.models;

public class Book {
    public int id;
    public String title;
    public String author;
    public Double price;
    public int quantity;

    public Book(int id, String title, String author, Double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }
}
