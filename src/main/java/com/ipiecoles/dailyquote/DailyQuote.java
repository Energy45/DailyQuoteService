package com.ipiecoles.dailyquote;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.StringJoiner;

public class DailyQuote {

    public DailyQuoteData getDailyQuote() throws ParseException {
        try {
            String responseJson = getPageContents("http://quotes.rest/qod.json");
            return parseJsonIntoDailyQuoteData(responseJson);
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }

    public DailyQuoteData getDailyQuote(String json) throws ParseException {
        return parseJsonIntoDailyQuoteData(json);
    }

    private DailyQuoteData parseJsonIntoDailyQuoteData(String json) throws ParseException {
        DailyQuoteData dailyQuoteData = new DailyQuoteData();
        JSONObject root = (JSONObject) new JSONParser().parse(json);

        if (root.containsKey("success")){
            JSONObject content = (JSONObject) root.get("contents");
            JSONArray quotes = (JSONArray) content.get("quotes");
            JSONObject dailyQuote = (JSONObject) quotes.get(0);

            dailyQuoteData.setAuthor((String) dailyQuote.get("author"));
            dailyQuoteData.setQuote((String) dailyQuote.get("quote"));
        }
        else {
            dailyQuoteData.setAuthor("un Auteur");
            dailyQuoteData.setQuote("une Quote");
        }
        return dailyQuoteData;
    }

    private String getPageContents(String address) throws IOException {
        BufferedReader br = null;
        StringJoiner lines = new StringJoiner(System.lineSeparator());
        try {
            URL url = new URL(address);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return lines.toString();

    }
}
