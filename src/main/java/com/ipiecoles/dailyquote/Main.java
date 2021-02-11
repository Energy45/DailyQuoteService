package com.ipiecoles.dailyquote;

import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) {
        DailyQuote dailyQuote = new DailyQuote();
        try {
            DailyQuoteData dailyQuoteData = dailyQuote.getDailyQuote();
            System.out.println(dailyQuoteData.toString());
        } catch (ParseException e) {
            System.err.println("Une erreur est survenue lors du parsage du JSON !");
        }
    }
}
