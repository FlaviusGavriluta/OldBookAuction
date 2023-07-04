package com.codecool.old_book_auction.model;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private LocalDateTime timestamp;
    private Bid bid;
    private Bidder bidder;

    public Transaction(int id, LocalDateTime timestamp, Bid bid, Bidder bidder) {
        this.id = id;
        this.timestamp = timestamp;
        this.bid = bid;
        this.bidder = bidder;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Bid getBid() {
        return bid;
    }

    public Bidder getBidder() {
        return bidder;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", bid=" + bid +
                ", bidder=" + bidder +
                '}';
    }
}
