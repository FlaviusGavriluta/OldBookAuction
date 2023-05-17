package com.codecool.old_book_auction;

import com.codecool.old_book_auction.model.Bid;
import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Book;
import com.codecool.old_book_auction.model.Topics;

import java.security.SecureRandom;
import java.util.*;

import static java.lang.System.*;

public class App {
    private static SecureRandom random = new SecureRandom();

    private static Topics getRandomTopic() {
        Topics[] topics = Topics.values();
        return topics[random.nextInt(topics.length)];
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
        String title = "Book #" + id;
        Topics topic = getRandomTopic();
        int price = getRandomPrice(minPrice, maxPrice);
        return new Book(id, title, topic, price);
    }

    public static void main(String[] args) {
        final int bookCount = 20;
        final int minPrice = 100;
        final int maxPrice = 300;

        final int bidderCount = 10;
        final int minimumCapital = 500;
        final int maximumCapital = 1000;

        Bidder[] bidders = new Bidder[bidderCount];
        for (int i = 0; i < bidderCount; i++) {
            bidders[i] = getRandomBidder(i + 1, minimumCapital, maximumCapital);
            out.println(bidders[i]);
        }

        Book[] books = new Book[bookCount];
        for (int i = 0; i < bookCount; i++) {
            books[i] = getRandomBook(i + 1, minPrice, maxPrice);
            out.println(books[i]);
        }
    }
}
