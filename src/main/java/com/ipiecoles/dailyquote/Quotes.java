package com.ipiecoles.dailyquote;

import java.util.Objects;

public class Quotes {
    private String author;
    private String quote;

    public Quotes() {
    }

    public Quotes(String author, String quote) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quotes quotes = (Quotes) o;
        return Objects.equals(author, quotes.author) &&
                Objects.equals(quote, quotes.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, quote);
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}
