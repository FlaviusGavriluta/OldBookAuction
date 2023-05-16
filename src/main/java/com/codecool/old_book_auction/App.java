package com.codecool.old_book_auction;


import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Book;
import com.codecool.old_book_auction.model.Topic;

public class App {
    public static void main(String[] args) {
        final int bookCount = 20;
        final int minPrice = 100;
        final int maxPrice = 300;

        final int bidderCount = 10;
        final int minimumCapital = 100;
        final int maximumCapital = 1000;

        Bidder e1 = new Bidder(2 , 2000.0, Topic.Astronomy, new Topic[] {Topic.Astronomy, Topic.History, Topic.Physics});
        System.out.println(e1);
        Book b1 = new Book(1,"test",Topic.Physics, 500);
        System.out.println(b1);
        System.out.println(e1.interested(b1));
        System.out.println(e1.canBid(b1, b1.getPrice()));
    }

}
