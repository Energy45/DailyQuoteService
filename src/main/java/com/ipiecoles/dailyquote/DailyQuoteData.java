package com.ipiecoles.dailyquote;

import java.time.LocalDate;
import java.util.List;

public class DailyQuoteData {

    private String author;
    private String quote;
    private List<String> tags;
    private String category;
    private String language;
    private LocalDate date;
    private String permalink;


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

    @Override
    public String toString() {
        return "DailyQuoteData{" +
                "author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                ", tags=" + tags +
                ", category='" + category + '\'' +
                ", language='" + language + '\'' +
                ", date=" + date +
                ", permalink='" + permalink + '\'' +
                '}';
    }
}
