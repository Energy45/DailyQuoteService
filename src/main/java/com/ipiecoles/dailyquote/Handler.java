package com.ipiecoles.dailyquote;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Handler implements RequestHandler<Object, GatewayResponse> {
    @Override
    public GatewayResponse handleRequest(Object input, Context context) {

        DailyQuote dailyQuote = new DailyQuote();
        try {
            //Appel ma méthode métier
            DailyQuoteData dailyQuoteData = dailyQuote.getDailyQuote();
            //Serialize en JSON l'objet de retour
            JSONObject root = new JSONObject();
            root.put("author", dailyQuoteData.getAuthor());
            root.put("quote", dailyQuoteData.getQuote());

            String body = root.toJSONString();
            //Gère les headers
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Access-Control-Allow-Origin", "https://pjvilloud.github.io");
            int statusCode = 200;
            //Renvoie de l'objet à API Gateway
            return new GatewayResponse(body, headers, statusCode);
        } catch (ParseException e) {
            //Gère correctement l'exception
            //loremipsum
            e.printStackTrace();
        }

        return null;
    }
}
