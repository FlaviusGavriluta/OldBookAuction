package com.codecool.old_book_auction.model;

import java.time.LocalDateTime;

public class Transaction {
    private final int id;
    private final Bidder bidder;

    private LocalDateTime timestamp;

    private final Bid bid;


    public Transaction(int id, Bidder bidder, LocalDateTime timestamp, Bid bid) {
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

    public LocalDateTime getTimestamp() {
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
