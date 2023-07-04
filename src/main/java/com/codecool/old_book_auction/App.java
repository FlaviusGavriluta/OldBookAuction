package com.codecool.old_book_auction;

import com.codecool.old_book_auction.model.*;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

=======
import java.security.SecureRandom;
import java.util.*;

import static java.lang.System.*;
>>>>>>> theAuction_FlvDev

public class App {
    private static SecureRandom random = new SecureRandom();

    private static Books getRandomBookTitle() {
        Books[] booksTitle = Books.values();
        return booksTitle[random.nextInt(booksTitle.length)];
    }

    private static Topics getRandomTopic() {
        Topics[] topics = Topics.values();
        return topics[random.nextInt(topics.length)];
    }

    private static String getRandomQuestion() {
        Auctioneer[] questions = Auctioneer.values();
        Auctioneer randomQuestion = questions[random.nextInt(questions.length)];
        return randomQuestion.getQuestion();
    }

    private static int getRandomPrice(int minPrice, int maxPrice) {
        return random.nextInt(maxPrice - minPrice + 1) + minPrice;
    }

    private static Bidder getRandomBidder(int id, int minimumCapital, int maximumCapital) {
        double capital = Math.round(random.nextDouble(maximumCapital - minimumCapital + 1) + minimumCapital);

        List<Topics> topics = new ArrayList<>(Arrays.asList(Topics.values()));
        Collections.shuffle(topics);

        Topics favourite = topics.get(0);
        Topics[] interested = {topics.get(1), topics.get(2)};

        return new Bidder(id, capital, favourite, interested);
    }

    private static Book getRandomBook(int id, int minPrice, int maxPrice) {
        Books title = getRandomBookTitle();
        Topics topic = getRandomTopic();
        int price = getRandomPrice(minPrice, maxPrice);
        return new Book(id, title, topic, price);
    }

    private static Bidder getRoundRobinBidderFromList(List<Bidder> bidders) {
        if (bidders.isEmpty()) {
            return null;
        }
        Bidder bidder = bidders.get(0);
        bidders.remove(0);
        bidders.add(bidder);
        return bidder;
    }

    private static List<Bidder> getInterestedBidders(List<Bidder> bidders, Book book) {
        List<Bidder> interestedBidders = new ArrayList<>();
        for (Bidder bidder : bidders) {
            if (bidder.interested(book) && bidder.canBid(book, book.getPrice())) {
                interestedBidders.add(bidder);
            }
        }
        return interestedBidders;
    }

    private static void runAuction(List<Book> books, List<Bidder> bidders) {
        List<Book> soldBooks = new ArrayList<>();
        out.println("Auctioneer: Ladies and gentlemen, welcome to today's book auction!\nWe have a fantastic selection of old books up for bidding.\nLet's begin!");
        out.println("");
        int soldPrice = 0;

        for (Book book : books) {
            out.println("Auctioneer (holding up Book #" + book.getId() + "): \""
                    + book.getBookTitle().toString().replace("_", " ")
                    + "\"." + "\nIt is from the " + book.getTopic() + " topic." +
                    "\nWe'll start the bidding from $" + book.getPrice() + ". " +
                    "Who offers more??");
            out.println("========================");

            List<Bidder> interestedBidders = getInterestedBidders(bidders, book);
            if (interestedBidders.isEmpty()) {
                out.println("Auctioneer: No bidders are interested in this book.");
                out.println("");
                out.println("");
                continue;
            }
            int currentPrice = book.getPrice();
            Bidder winner = null;

            if (interestedBidders.size() == 1) {
                winner = interestedBidders.get(0);
                soldBooks.add(book);
                soldPrice = currentPrice;

                out.println("Auctioneer: " + winner.getName() + " wins the book \""
                        + book.getBookTitle().toString().replace("_", " ")
                        + "\" for $" + currentPrice + "!");
                out.println("And that concludes our book auction. Thank you all for participating!");
                out.println("");
                out.println("");
                winner.buyBook(book);
                continue;
            }

            while (interestedBidders.size() > 1) {
                Bidder bidder = getRoundRobinBidderFromList(interestedBidders);
                Bid currentBid = new Bid(bidder, currentPrice);
                Bid newBid = bidder.getBid(book, currentBid);

                if (newBid.getBidPrice() <= currentPrice) {
                    interestedBidders.remove(bidder);
                    out.println(bidder.getName() + ": I'm out!");
                    continue;
                }
                currentPrice = newBid.getBidPrice();
                book.setSoldPrice(currentPrice);
                currentBid = newBid;
                winner = bidder;
                out.println(bidder.getName() + ": $" + currentBid.getBidPrice());
                out.println("Auctioneer: We have $" + currentBid.getBidPrice() +
                        " from " + bidder.getName() + ". " + getRandomQuestion());
            }
            if (winner != null) {
                soldBooks.add(book);
                out.println("========================");
                out.println("Auctioneer: " + winner.getName() + " raises to $" + currentPrice
                        + ". And sold to " + winner.getName() + " for $" + currentPrice + "!");

                out.println("Auctioneer: Congratulations to " + winner.getName() + " for " +
                        "winning the book: \"" + book.getBookTitle().toString().replace("_", " ") + "\"!");
                out.println("And that concludes our book auction. Thank you all for participating!");
                out.println("");
                out.println("");
                winner.buyBook(book);
            }
        }

        out.println("\n* The books sold are:");
        for (Book book : soldBooks) {
            out.println("\"" + book.getBookTitle().toString().replace("_", " ") + "\"");

        }

    }

    public static void main(String[] args) {
        final int bookCount = 20;
        final int minPrice = 100;
        final int maxPrice = 300;


        final int bidderCount = 10;
        final int minimumCapital = 100;
        final int maximumCapital = 1000;

<<<<<<< HEAD
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
=======
        List<Bidder> bidders = new ArrayList<>();
        for (int i = 0; i < bidderCount; i++) {
            bidders.add(getRandomBidder(i + 1, minimumCapital, maximumCapital));
        }

        List<Book> books = new ArrayList<>();
        for (int i = 0; i < bookCount; i++) {
            books.add(getRandomBook(i + 1, minPrice, maxPrice));
        }
        runAuction(books, bidders);
>>>>>>> theAuction_FlvDev
    }
}
