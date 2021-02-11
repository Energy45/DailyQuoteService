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
        //String responseJSON = getPageContents("http://quotes.rest/qod.json");
        String responseJSON = "{\n" +
                "    \"success\": {\n" +
                "        \"total\": 1\n" +
                "    },\n" +
                "    \"contents\": {\n" +
                "        \"quotes\": [\n" +
                "            {\n" +
                "                \"quote\": \"Logic will get you from A to B. Imagination will take you everywhere.\",\n" +
                "                \"length\": \"69\",\n" +
                "                \"author\": \"Albert Einstein\",\n" +
                "                \"tags\": [\n" +
                "                    \"imagination\",\n" +
                "                    \"inspire\",\n" +
                "                    \"t-shirt\"\n" +
                "                ],\n" +
                "                \"category\": \"inspire\",\n" +
                "                \"language\": \"en\",\n" +
                "                \"date\": \"2021-02-11\",\n" +
                "                \"permalink\": \"https://theysaidso.com/quote/albert-einstein-logic-will-get-you-from-a-to-b-imagination-will-take-you-everywh\",\n" +
                "                \"id\": \"cfDPmVkuKVadLkHsmY5hxAeF\",\n" +
                "                \"background\": \"https://theysaidso.com/img/qod/qod-inspire.jpg\",\n" +
                "                \"title\": \"Inspiring Quote of the day\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"baseurl\": \"https://theysaidso.com\",\n" +
                "    \"copyright\": {\n" +
                "        \"year\": 2023,\n" +
                "        \"url\": \"https://theysaidso.com\"\n" +
                "    }\n" +
                "}";
        DailyQuoteData dailyQuoteData = genson.deserialize(responseJSON, DailyQuoteData.class);
        System.out.println(dailyQuoteData.toString());
        return dailyQuoteData;
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
