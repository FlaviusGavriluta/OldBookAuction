package com.codecool.old_book_auction;
import com.codecool.old_book_auction.model.*;


public class App {
    public static void main(String[] args) {
        final int bookCount = 20;
        final int minPrice = 100;
        final int maxPrice = 300;


        final int bidderCount = 10;
        final int minimumCapital = 100;
        final int maximumCapital = 1000;

        Book[] bookObjects = new Book[bookCount];
        Bidder[] bidderObjects = new Bidder[bidderCount];

        Book b1 = new Book(1,Books.values()[1],Topic.Physics, 100);
        System.out.println(b1);
        Bidder e1 = new Bidder(2 , 2000.0, Topic.Astronomy, new Topic[] {Topic.History, Topic.Physics});
        System.out.println(e1);
        Bid n1 = new Bid( 3, e1, b1.getPrice());
        System.out.println(e1.interested(b1));
        System.out.println(e1.canBid(b1, b1.getPrice()));
        System.out.println(e1.getBid(b1, n1));
        GenerateRandom rand = new GenerateRandom();

        for ( int i=0; i < bookCount; i++) {
         bookObjects[i] = new Book(i+1, Books.values()[rand.generateRandom(20)] , Topic.values()[rand.generateRandom(5)], rand.generateRandom(maxPrice));
        }

        for ( int i=0; i< bidderCount; i++) {
            Topic randTopic1 = Topic.values()[rand.generateRandom(5)];
            Topic randTopic2 = Topic.values()[rand.generateRandom(5)];
            bidderObjects[i] = new Bidder(i+1, rand.generateRandom(maximumCapital), Topic.values()[rand.generateRandom(5)], new Topic[] {randTopic1, randTopic2} );
        }
        System.out.println(bookObjects[19]);
        System.out.println(bidderObjects[2]);


    }

}
