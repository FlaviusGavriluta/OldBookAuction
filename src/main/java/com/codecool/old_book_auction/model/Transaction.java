package com.codecool.old_book_auction.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
    private final int id;
    private final Bidder bidder;

    private Date date;

    private final Bid bid;


    public Transaction(int id, Bidder bidder, Date date, Bid bid) {
        this.id = id;
        this.bidder = bidder;
        this.date = date;
        this.bid = bid;
    }

    public int getId() {
        return id;
    }

    public Bidder getBidder() {
        return bidder;
    }



    public Bid getBid() {
        return bid;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", bidder=" + bidder +
                ", timestamp='" + date + '\'' +
                ", bid=" + bid +
                '}';
    }

    public Date getDate() {
        return date;
    }
}
