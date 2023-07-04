package com.codecool.old_book_auction.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bidder {
    private int id;
    private String name;
    private double capital;
    private final List<Book> books = new ArrayList<Book>();
    private final Topics favourite;
    private final Topics[] interested;


    public Bidder(int id, double capital, Topics favourite, Topics[] interested) {
        this.id = id;
        this.capital = capital;
        this.favourite = favourite;
        this.interested = interested;
        this.name = "Bidder #" + id;
    }

    public boolean interested(Book book) {
        Topics bookTopic = book.getTopic();
        return (bookTopic == favourite || Arrays.asList(interested).contains(bookTopic));
    }

    public boolean canBid(Book book, int currentPrice) {
        return currentPrice < getThresholdPrice(book.getTopic());
    }

    public Bid getBid(Book book, Bid currentBid) {
        int bidPrice = getBidPrice(currentBid.getBidPrice(), getThresholdPrice(book.getTopic()));
        return new Bid(this, bidPrice);
    }

    private static int getBidPrice(int currentPrice, int threshold) {
        int range = threshold - currentPrice;
        return (range / 2) + currentPrice;
    }

    private int getThresholdPrice(Topics topic) {
        return topic == favourite ? (int) (capital * 0.5) : (int) (capital * 0.25);
    }

    public void buyBook(Book book) {
        capital -= book.getPrice();
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Topics getFavourite() {
        return favourite;
    }

    public Topics[] getInterested() {
        return interested;
    }

    public double getCapital() {
        return capital;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bidder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", books=" + books +
                ", favourite=" + favourite +
                ", interested=" + Arrays.toString(interested) +
                '}';
    }
}
