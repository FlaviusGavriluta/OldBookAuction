package com.codecool.old_book_auction.model;

public class Book {
    private int id;
    private String title;
    private Topics topic;
    private int price;

    public Book(int id, String name, Topics topic, int price) {
        this.id = id;
        this.title = name;
        this.topic = topic;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Topics getTopic() {
        return topic;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", topic=" + topic +
                ", price=" + price +
                '}';
    }
}
