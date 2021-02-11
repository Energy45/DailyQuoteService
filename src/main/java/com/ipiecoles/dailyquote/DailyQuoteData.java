package com.ipiecoles.dailyquote;

public class DailyQuoteData {

    private String author;
    private String quote;

    public DailyQuoteData() {
    }

    public DailyQuoteData(String author, String quote) {
        this.author = author;
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
