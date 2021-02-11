package com.ipiecoles.dailyquote;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DailyQuote dailyQuote = new DailyQuote();
        System.out.println(dailyQuote.getDailyQuote().toString());

        System.out.println(dailyQuote.getPageContents("http://quotes.rest/qod.json"));


    }
}
