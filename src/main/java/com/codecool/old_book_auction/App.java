package com.codecool.old_book_auction;

import com.codecool.old_book_auction.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;


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
        ArrayList<Book> soldBooks = new ArrayList<>();

        for (int i = 0; i < bookCount; i++) {
            bookObjects[i] = new Book(
                    i + 1,
                    Books.values()[GenerateRandom.generateRandom(bookCount)],
                    Topic.values()[GenerateRandom.generateRandom(5)],
                    GenerateRandom.generateRandom(minPrice, maxPrice)
            );
        }
        for (int i = 0; i < bidderCount; i++) {
            ArrayList<Topic> shuffledTopics = new ArrayList<>(Arrays.asList(Topic.values()));
            Collections.shuffle(shuffledTopics);
            Topic FavTopic = shuffledTopics.get(0);
            Topic IntrTopic1 = shuffledTopics.get(1);
            Topic IntrTopic2 = shuffledTopics.get(2);
            bidderObjects[i] = new Bidder(i + 1,
                    GenerateRandom.generateRandom(minimumCapital, maximumCapital),
                    FavTopic,
                    new Topic[]{IntrTopic1, IntrTopic2});
        }
        for (int i = 0; i < bookCount; i++) {
            ArrayList<Bidder> interestedBidders = new ArrayList<>();
            ArrayList<Bid> bidds = new ArrayList<>();
            ArrayList<Bidder> copyOfInterested = new ArrayList<>();
            System.out.println("\n");
            System.out.println("Cartea scoasa la licitatie");
            System.out.println("Titlu : " + bookObjects[i].getTitle());
            System.out.println("Pret pornire : " + bookObjects[i].getPrice());
            System.out.println("Gen : " + bookObjects[i].getTopic());
            System.out.println("=========");

            for (int j = 0; j < bidderCount; j++) {
                if (bookObjects[i].getTopic() == bidderObjects[j].getFavourite() ||
                        Arrays.asList(bidderObjects[j].getInterested()).contains(bookObjects[i].getTopic())) {
                    if (bidderObjects[j].canBid(
                            bookObjects[i],
                            bookObjects[i].getCurrentBid())) {
                        interestedBidders.add(bidderObjects[j]);
                        copyOfInterested.add(bidderObjects[j]);
                    }
                }
            }
            System.out.println("Bidders : " + interestedBidders);
            while (interestedBidders.size() >= 1) {
                for (int k = 0; k < interestedBidders.size(); k++) {
                    Bid nextBid = new Bid(GenerateRandom.generateRandom(),
                            interestedBidders.get(k),
                            interestedBidders.get(k).makeBid(bookObjects[i]));
                    if ( nextBid.getPrice() <= bookObjects[i].getCurrentBid() ){
                        System.out.println("A iesit din licitatie : " + interestedBidders.get(k).getName());
                        copyOfInterested.remove(copyOfInterested.get(k));
                        interestedBidders = new ArrayList<>(copyOfInterested);
                    } else {
                        bidds.add(nextBid);
                        bookObjects[i].setCurrentBid(bidds.get(bidds.size() - 1).getPrice());
                        System.out.println("Bids : " + bidds.get(bidds.size()-1).getPrice() + " " + bidds.get(bidds.size()-1).getBidder().getName());
                        System.out.println("Current bid : " + bookObjects[i].getCurrentBid() + " ! Going once... ");
                        if (bidds.get(bidds.size() - 1).getPrice() <= bookObjects[i].getCurrentBid()) {
                            copyOfInterested.remove(copyOfInterested.get(k));
                            interestedBidders = new ArrayList<>(copyOfInterested);
                        }
                    }
                }
            }
            if (bidds.size() == 0) {
                System.out.println("Nu sunt interesati");
            }
            if (bidds.size() == 1) {
                bidds.get(0).getBidder().buyBook(bookObjects[i]);
                soldBooks.add(bookObjects[i]);
                Transaction transaction = new Transaction(GenerateRandom.generateRandom(),
                        bidds.get(0).getBidder(), new Date(), bidds.get(0));
                System.out.println("Winner : " + bidds.get(0).getBidder().getName());
                System.out.println(transaction);
            }
            if (bidds.size() > 1) {
                bidds.get(bidds.size() - 1).getBidder().buyBook(bookObjects[i]);
                soldBooks.add(bookObjects[i]);
                Transaction transaction = new Transaction(GenerateRandom.generateRandom(),
                        bidds.get(bidds.size() - 1).getBidder(), new Date(), bidds.get(0));
                System.out.println("Winner : " + bidds.get(bidds.size()-1).getBidder().getName());
                System.out.println(transaction);
            }
        }
        System.out.println("\n");
        System.out.println("Sold Books : \n");
        for (int n = 0; n < soldBooks.size(); n++) {
            System.out.println(soldBooks.get(n).getTitle());
            System.out.println("pretul intial : " + soldBooks.get(n).getPrice());
            System.out.println("pretul de vanzare : " + soldBooks.get(n).getCurrentBid());
            System.out.println("----------");
        }
    }
}
