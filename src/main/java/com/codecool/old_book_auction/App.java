package com.codecool.old_book_auction;

import com.codecool.old_book_auction.model.Bid;
import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Book;
import com.codecool.old_book_auction.model.Topics;

import static java.lang.System.*;

public class App {
    public static void main(String[] args) {
        final int bookCount = 20;
        final int minPrice = 100;
        final int maxPrice = 300;

        final int bidderCount = 10;
        final int minimumCapital = 100;
        final int maximumCapital = 1000;

        Bidder John = new Bidder(1, 2000, Topics.Archeology, new Topics[]{Topics.Archeology, Topics.History, Topics.Medicine});
        out.println(John);

        Book firstBook = new Book(1, "Price Action", Topics.Physics, 200);
        out.println(firstBook);

        Bid firstBid = new Bid(1, John, 300);
        out.println(firstBid);
    }
}
