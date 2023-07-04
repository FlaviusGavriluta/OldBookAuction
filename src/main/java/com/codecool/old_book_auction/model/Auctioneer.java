package com.codecool.old_book_auction.model;

public enum Auctioneer {
    ARE_WE_FINISHED("Are we finished?"),
    ANY_MORE_BIDS("Any more bids?"),
    ARE_WE_DONE("Are we done?"),
    LAST_CHANCE_FOR_OTHER_BIDDERS("Last chance for other bidders..."),
    ANY_OTHER_BIDS("Any other bids?"),
    GOING_ONCE_GOING_TWICE("Going once, going twice..."),
    ANY_HIGHER_BIDS("Any higher bids?");

    private final String question;

    Auctioneer(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}
