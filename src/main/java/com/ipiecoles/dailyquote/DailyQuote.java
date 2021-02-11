package com.ipiecoles.dailyquote;

import com.owlike.genson.Genson;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.StringJoiner;

public class DailyQuote {

    public DailyQuoteData getDailyQuote() {
        Genson genson = new Genson();
        try {
            String responseJSON = getPageContents("http://quotes.rest/qod.json");
            DailyQuoteData dailyQuoteData = genson.deserialize(responseJSON, DailyQuoteData.class);
            System.out.println(dailyQuoteData.toString());
            return dailyQuoteData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPageContents(String address) throws IOException {
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
