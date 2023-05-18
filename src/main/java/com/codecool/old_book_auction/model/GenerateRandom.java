package com.codecool.old_book_auction.model;
import  java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateRandom {
    public static int generateRandom(int upperbound) {

        SecureRandom rand = new SecureRandom();

    return rand.nextInt(upperbound);
    }

    public static int generateRandom() {

        SecureRandom rand = new SecureRandom();

        return rand.nextInt(Integer.MAX_VALUE);
    }

    public static int generateRandom( int min, int max ) {
        SecureRandom rand = new SecureRandom();
        return Math.round(rand.nextInt(max-min+1)+min);

    }





}
