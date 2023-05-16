package com.codecool.old_book_auction.model;

public class Transaction {

    //Transaction: a transaction is created when a book is successfully sold to a bidder.
    // It has an id and a timestamp, and has reference to the Bid and the Bidder objects.

    private final int id;
    private final Bidder bidder;

    private final String timestamp;

    private final Bid bid;


    public Transaction(int id, Bidder bidder, String timestamp, Bid bid) {
        this.id = id;
        this.bidder = bidder;
        this.timestamp = timestamp;
        this.bid = bid;
    }

    public int getId() {
        return id;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Bid getBid() {
        return bid;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", bidder=" + bidder +
                ", timestamp='" + timestamp + '\'' +
                ", bid=" + bid +
                '}';
    }
}
