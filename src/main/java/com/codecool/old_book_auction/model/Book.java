package com.codecool.old_book_auction.model;

public class Book {
    private int id;
    private Books title;
    private Topics topic;
    private int price;
    private int soldPrice;

    public Book(int id, Books name, Topics topic, int price) {
        this.id = id;
        this.title = name;
        this.topic = topic;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Books getBookTitle() {
        return title;
    }

    public Topics getTopic() {
        return topic;
    }

    public int getPrice() {
        return price;
    }

    public void setSoldPrice(int soldPrice) {
        this.soldPrice = soldPrice;
    }

    public int getSoldPrice() {
        return soldPrice;
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
