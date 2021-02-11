package com.ipiecoles.dailyquote;

import com.owlike.genson.annotation.JsonProperty;

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

    public DailyQuoteData(@JsonProperty("quotes") List<Quotes> quotesList) {
        if(quotesList.size() == 1) {
            this.author = quotesList.get(0).getAuthor();
            this.quote = quotesList.get(0).getQuote();
        }
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
