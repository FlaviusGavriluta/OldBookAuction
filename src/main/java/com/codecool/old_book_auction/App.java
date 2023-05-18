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
            System.out.println(bookObjects[i].getTitle());
            System.out.println(bookObjects[i].getPrice());
            System.out.println(bookObjects[i].getTopic());
            System.out.println("=========");

            for (int j = 0; j < bidderCount; j++) {
                if (bookObjects[i].getTopic() == bidderObjects[j].getFavourite() ||
                        Arrays.asList(bidderObjects[j].getInterested()).contains(bookObjects[i].getTopic())) {
                    interestedBidders.add(bidderObjects[j]);
                    copyOfInterested.add(bidderObjects[j]);
                }
            }
            Collections.shuffle(interestedBidders);
            System.out.println("Licitatorii");
            System.out.println(interestedBidders);
            System.out.println("----------");

            boolean sold = false;
            while (!sold) {
                for (int k = 0; k < interestedBidders.size(); k++) {
                    if (interestedBidders.get(k).canBid(
                            bookObjects[i],
                            bookObjects[i].getCurrentBid())
                    ) {
                        bidds.add(new Bid(GenerateRandom.generateRandom(),
                                interestedBidders.get(k),
                                interestedBidders.get(k).makeBid(bookObjects[i])));
                        System.out.println("pret initial:" + bookObjects[i].getPrice());
                        bookObjects[i].setCurrentBid(bidds.get(bidds.size() - 1).getPrice());
                        System.out.println("pret de licitare : " + bookObjects[i].getCurrentBid());
                        System.out.println("Licitatiile");
                        System.out.println(bidds);
                        System.out.println("----------");
                    } else {
                        System.out.println(interestedBidders);
                        copyOfInterested.remove(copyOfInterested.get(k));
                    }
                    interestedBidders = new ArrayList<>(copyOfInterested);
                }

                if (interestedBidders.size() == 1 && bidds.size() > 0) {
                    System.out.println(interestedBidders.get(0).getCapital());
                    interestedBidders.get(0).buyBook(bookObjects[i]);
                    System.out.println(interestedBidders.get(0).getCapital());
                    System.out.println(bookObjects[i]);
                    System.out.println("Licitatia Oprita");
                    System.out.println("Book Sold! For : " + bookObjects[i].getCurrentBid() + " Winner : " + interestedBidders.get(0).getName());
                    soldBooks.add(bookObjects[i]);
                    Transaction transaction = new Transaction(GenerateRandom.generateRandom(), interestedBidders.get(0),new Date(), bidds.get(0));
                    System.out.println(transaction);
                } else {
                    System.out.println("Licitatia Continua");
                    System.out.println(interestedBidders);
                }

                if(interestedBidders.size() == 1) {
                    sold = true;
                }
            }
        }
        for (int n = 0 ; n < soldBooks.size(); n++) {
            System.out.println("\n");
            System.out.println("Sold Books : " + soldBooks.get(n).getTitle());
            System.out.println("pretul intial : " + soldBooks.get(n).getPrice());
            System.out.println("pretul de vanzare : " + soldBooks.get(n).getCurrentBid());
            System.out.println("----------");
        }

}

}
