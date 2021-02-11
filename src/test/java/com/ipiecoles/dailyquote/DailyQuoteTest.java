package com.ipiecoles.dailyquote;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class DailyQuoteTest {

    @Test
    public void testDailyQuote() {
        //Givent
        DailyQuote dailyQuote = new DailyQuote();
        String authorQuote = "Albert Einstein";
        String quoteContent = "Logic will get you from A to B. Imagination will take you everywhere.";
        String idTest = "cfDPmVkuKVadLkHsmY5hxAeF";

        //When
        DailyQuoteData dailyQuoteData = dailyQuote.getDailyQuote();

        //Then
        assertThat(dailyQuoteData.getAuthor()).isEqualTo(authorQuote);
        assertThat(dailyQuoteData.getQuote()).isEqualTo(quoteContent);

        /*
        {
            "author":"Mark Twain",
            "quote":"Keep away from people who try to belittle your ambitions. Small people always do that, but the really great makes you feel that you, too, can become great...."
        }
         */
    }
}
