package com.codecool.old_book_auction.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bidder {
    private final List<Book> books = new ArrayList<Book>();
    private final Topic favourite;
    private final Topic[] interested;

    private double capital;

    private int id;
    private String name;

    @Override
    public String toString() {
        return "Bidder{" +
                "books=" + books +
                ", favourite=" + favourite +
                ", interested=" + Arrays.toString(interested) +
                ", capital=" + capital +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Bidder(int id, double capital, Topic favourite, Topic[] interested){
        this.id = id;
        this.capital = capital;
        this.favourite = favourite;
        this.interested = interested;
        this.name = "Bidder #"+ id;
    }

    public boolean interested(Book book){
        for (Topic topic : interested) {
            if ( topic == book.getTopic()) {
                return true;
            }
        }

        return false;
    }

    public boolean canBid(Book book, int currentPrice){
        return getThresholdPrice(book.getTopic()) > currentPrice;
    }

    public Bid getBid(Book book, Bid currentBid){
        return null;
        //TODO
    }

    private static int getBidPrice(int currentPrice, int threshold){
        return 0;
        //TODO
    }

    private int getThresholdPrice(Topic topic){
      if(Arrays.asList(this.interested).contains(topic)) {
          return (int) (0.25*this.capital);
      }
      if(this.favourite.equals(topic)) return (int) (0.5 * this.capital);

      return 0;
    }

    public void buyBook(Book book){
        //TODO
    }
}
