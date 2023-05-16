package com.codecool.old_book_auction.model;

public class Book {

    private final int id;

    private final Books books;

    private final Topic topic;

    private final int price;

    private int currentBid;
    public Book(int id, Books books, Topic topic, int price) {
        this.id = id;
        this.books = books;
        this.topic = topic;
        this.price = price;
        this.currentBid = price;
    }


    public int getId() {
        return id;
    }

    public Books getTitle() {
        return books;
    }

    public Topic getTopic() {
        return topic;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + books + '\'' +
                ", topic='" + topic + '\'' +
                ", price=" + price +
                '}';
    }

    public void setCurrentBid(Bid currentBid) {
        this.currentBid = currentBid.getPrice();
    }

    public int getCurrentBid() {
        return currentBid;
    }
}
