package com.codecool.old_book_auction.model;

public class Bid {
    private final int id;
    private final Bidder bidder;

    private final int price;


    public Bid(int id, Bidder bidder, int price) {
        this.id = id;
        this.bidder = bidder;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", bidder=" + bidder.getName() +
                ", price=" + price +
                '}';
    }
}
