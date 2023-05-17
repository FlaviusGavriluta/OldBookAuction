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
        return false;
        //TODO
    }

    public boolean canBid(Book book, int currentPrice) {
        return false;
        //TODO
    }

    public Bid getBid(Book book, Bid currentBid) {
        return null;
        //TODO
    }

    private static int getBidPrice(int currentPrice, int threshold) {
        return 0;
        //TODO
    }

    private int getThresholdPrice(Topics topic) {
        return 0;
        //TODO
    }

    public void buyBook(Book book) {
        //TODO
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

    public int getId() {
        return id;
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
