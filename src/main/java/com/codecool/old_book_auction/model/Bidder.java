package com.codecool.old_book_auction.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bidder {
    private final List<Book> books = new ArrayList<Book>();
    private final Topic favourite;
    private final Topic[] interested;
    private final float THRESHOLD_FAV = .5F;
    private final float THRESHOLD_INTR = 0.25F;
    private double capital;

    private int id;
    private String name;

    @Override
    public String toString() {
        return "Bidder{" +
                "books=" + books +
                ", favourite=" + favourite +
                ", interested=" + Arrays.toString(interested) +
                ", capital=" + capital +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Bidder(int id, double capital, Topic favourite, Topic[] interested) {
        this.id = id;
        this.capital = capital;
        this.favourite = favourite;
        this.interested = interested;
        this.name = "Bidder #" + id;
    }

    public boolean interested(Book book) {
        for (Topic topic : interested) {
            if (topic == book.getTopic()) {
                return true;
            }
        }

        return false;
    }


    public boolean canBid(Book book, int currentPrice) {
        int maxAmount = getThresholdPrice(book.getTopic());
        if (maxAmount > currentPrice) return true;
        else return false;
    }

    public Bid getBid(Book book, Bid currentBid) {
        if (book.getCurrentBid() <= getBidPrice(book.getCurrentBid(), getThresholdPrice(book.getTopic())))
            return currentBid;
        return null;
    }

    public int makeBid(Book book) {
        int maxPay = getThresholdPrice(book.getTopic());
        return getBidPrice(book.getCurrentBid(), maxPay);
    }

    private static int getBidPrice(int currentPrice, int threshold) {
            return (threshold - currentPrice) / 2 + currentPrice;
    }

    private int getThresholdPrice(Topic topic) {
        if (this.favourite.equals(topic)) {
            return (int) (THRESHOLD_FAV * this.capital);
        }
        if (Arrays.asList(this.interested).contains(topic)) {
            return (int) (THRESHOLD_INTR * this.capital);
        }
        return 0;
    }

    public void buyBook(Book book) {
        setCapital(this.capital - book.getCurrentBid());
    }

    public Topic getFavourite() {
        return favourite;
    }

    public Topic[] getInterested() {
        return interested;
    }

    public String getName() {
        return name;
    }

    public double getCapital() {
        return capital;
    }
}
