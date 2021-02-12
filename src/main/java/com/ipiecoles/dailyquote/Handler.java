package com.ipiecoles.dailyquote;

import com.sun.tools.sjavac.server.RequestHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Handler implements RequestHandler<Object, GatewayResponse> {
    @Override
    public GatewayResponse handlerRequest(Object input, Context context) {

        DailyQuote dailyQuote = new DailyQuote();
        try{
            dailyQuote.getDailyQuoteFromDate(LocalDate.now());
            String body;
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Access-Control ", "application/json");
            int statusCode = 200;

            GatewayResponse gatewayResponse = new GatewayResponse(body headers statusCode);
            return  gatewayResponse;
        }
        catch (Exception e){

        }

    }
}
