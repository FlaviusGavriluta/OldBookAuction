package com.codecool.old_book_auction.model;

public class Bid {
    private int id;
    private Bidder bidder;
    private int bidPrice;
    private static int counter = 0;

    public Bid(Bidder bidder, int bidPrice) {
        this.id = counter;
        counter++;
        this.bidder = bidder;
        this.bidPrice = bidPrice;
    }

    public int getId() {
        return id;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", bidder=" + bidder.getName() +
                ", bidPrice=" + bidPrice +
                '}';
    }
}
