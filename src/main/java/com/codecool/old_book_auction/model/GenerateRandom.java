package com.codecool.old_book_auction.model;
import  java.security.SecureRandom;

public class GenerateRandom {
    public int generateRandom(int upperbound) {

        SecureRandom rand = new SecureRandom();

    return rand.nextInt(upperbound);
    }
}
