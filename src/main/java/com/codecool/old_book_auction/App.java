package com.codecool.old_book_auction;

import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Topics;

public class App {
    public static void main(String[] args) {
        final int bookCount = 20;
        final int minPrice = 100;
        final int maxPrice = 300;

        final int bidderCount = 10;
        final int minimumCapital = 100;
        final int maximumCapital = 1000;

        Bidder b1 = new Bidder(2, 2000, Topics.Archeology, new Topics[]{Topics.Archeology, Topics.History, Topics.Medicine});
        System.out.println(b1);
    }
}
