package com.ipiecoles.dailyquote;

import static org.assertj.core.api.Assertions.*;

import org.json.simple.parser.ParseException;
import org.junit.Test;

public class DailyQuoteTest {

    @Test
    public void testDailyQuote() throws ParseException {
        //Given
        DailyQuote dailyQuote = new DailyQuote();
        String authorQuote = "Albert Einstein";
        String quoteContent = "Logic will get you from A to B. Imagination will take you everywhere.";
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

        //When
        DailyQuoteData dailyQuoteData = dailyQuote.getDailyQuote(responseJSON);

        //Then
        assertThat(dailyQuoteData.getAuthor()).isEqualTo(authorQuote);
        assertThat(dailyQuoteData.getQuote()).isEqualTo(quoteContent);
    }
}
