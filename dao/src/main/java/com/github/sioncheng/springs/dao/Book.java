package com.github.sioncheng.springs.dao;

public class Book {

    private String name;
    private String ISBN;
    private String publication;
    private int price;
    private String author;

    public Book() {
        this("noname", "noisbn", "nopublication", 0, "noauthor");
    }

    public Book(String name, String ISBN, String publication, int price, String author) {
        this.name = name;
        this.ISBN = ISBN;
        this.publication = publication;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
