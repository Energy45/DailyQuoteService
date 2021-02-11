package com.ipiecoles.dailyquote;

import org.junit.Test;

public class DailyQuoteTest {

    @Test
    public void testDailyQuote() {
        DailyQuote dailyQuote = new DailyQuote();

        DailyQuoteData dailyQuoteData = dailyQuote.getDailyQuote();

        /*
        {
            "author":"Mark Twain",
            "quote":"Keep away from people who try to belittle your ambitions. Small people always do that, but the really great makes you feel that you, too, can become great...."
        }
         */
    }
}
