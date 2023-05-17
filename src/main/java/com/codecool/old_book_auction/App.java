package com.codecool.old_book_auction;

import com.codecool.old_book_auction.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


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

//        Book b1 = new Book(1,Books.values()[1],Topic.Physics, 100);
//        System.out.println(b1);
//        Bidder e1 = new Bidder(2 , 2000.0, Topic.Astronomy, new Topic[] {Topic.History, Topic.Physics});
//        System.out.println(e1);
//        Bid n1 = new Bid( 3, e1, b1.getPrice());
//        System.out.println(e1.interested(b1));
//        System.out.println(e1.canBid(b1, b1.getPrice()));
//        System.out.println(e1.getBid(b1, n1));
//        GenerateRandom rand = new GenerateRandom();

        for (int i = 0; i < bookCount; i++) {
            bookObjects[i] = new Book(
                    i + 1,
                    Books.values()[GenerateRandom.generateRandom(bookCount)],
                    Topic.values()[GenerateRandom.generateRandom(5)],
                    GenerateRandom.generateRandom(maxPrice)
            );
        }

        for (int i = 0; i < bidderCount; i++) {
            ArrayList<Topic> shuffledTopics = new ArrayList<Topic>(Arrays.asList(Topic.values()));

            Collections.shuffle(shuffledTopics);
            Topic FavTopic = shuffledTopics.get(0);
            Topic IntrTopic1 = shuffledTopics.get(1);
            Topic IntrTopic2 = shuffledTopics.get(2);
            bidderObjects[i] = new Bidder(i + 1,
                    GenerateRandom.generateRandom(maximumCapital),
                    FavTopic,
                    new Topic[]{IntrTopic1, IntrTopic2});
        }
//        System.out.println(bookObjects[19]);
//        System.out.println(bidderObjects[2]);

        for (int i = 0; i < bookCount; i++) {
            //    Bidder[] interestedBidders = new Bidder[];
            ArrayList<Bidder> interestedBidders = new ArrayList<>();
            ArrayList<Bid> bidds = new ArrayList<>();
//            System.out.println(bookObjects[i].getTitle());
//            System.out.println(bookObjects[i].getTopic());
//            System.out.println(bookObjects[i].getPrice());
            for (int j = 0; j < bidderCount; j++) {

                if (bookObjects[i].getTopic() == bidderObjects[j].getFavourite()) {
                    interestedBidders.add(bidderObjects[j]);
                }

            }
            Collections.shuffle(interestedBidders);
            System.out.println(bookObjects[i].getTitle());
            System.out.println(bookObjects[i].getPrice());
            System.out.println("=========");
            for (int k = 0; k < interestedBidders.size(); k++) {
               if(interestedBidders.get(k).canBid(bookObjects[i],
                        bookObjects[i].getCurrentBid())) {
                   bidds.add(new Bid(GenerateRandom.generateRandom(),
                           interestedBidders.get(k),
                           interestedBidders.get(k).makeBid(bookObjects[i])));

                   bookObjects[i].setCurrentBid(bidds.get(bidds.size() - 1).getPrice());

                   System.out.println(bookObjects[i].getTitle());
                   System.out.println(bookObjects[i].getCurrentBid());
                     System.out.println(bidds.get(bidds.size()-1).getPrice());
                   System.out.println(bidds);
                   System.out.println(interestedBidders.get(k).makeBid(bookObjects[i]));
                   System.out.println("----------");
               }
            }

//            for (int nBidder = 0; nBidder < interestedBidders.size(); nBidder++) {
//                if (interestedBidders[nBidder]
//            }

//            int randBidder = rand.generateRandom(interestedBidders.length-1);
//            while (interestedBidders[randBidder].canBid(bookObjects[i],
//                    bookObjects[i].getCurrentBid())) {
//
//                bookObjects[i].setCurrentBid(new Bid(i + 1,
//                        interestedBidders[randBidder],
//                        bookObjects[i].getCurrentBid() + 1));
//                System.out.println(bookObjects[i].getCurrentBid());

            //}


        }

//                    if(bidderObjects[j].canBid(bookObjects[i], bookObjects[i].getCurrentBid())) {
//
//
//                    }
//                    System.out.println(bidderObjects[j].canBid(bookObjects[i], bookObjects[i].getCurrentBid()));
//                    System.out.println(bidderObjects[j].getCapital());
//                    System.out.println(bookObjects[j].getCurrentBid());

        //System.out.println(bidderObjects[j].getName() + "vrea sa cumpere");

    }

}
