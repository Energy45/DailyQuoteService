package com.ipiecoles.dailyquote;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Handler implements RequestHandler<Object, GatewayResponse> {
    @Override
    public GatewayResponse handleRequest(Object input, Context context) {

        Ephemeride ephemeride = new Ephemeride();
        try {
            //Appel ma méthode métier
            EphemerideData ephemerideData = ephemeride.getEphemerideFromDate(LocalDate.now());
            //Serialize en JSON l'objet de retour
            Genson genson = new GensonBuilder().useRuntimeType(true).create();
            String body = genson.serialize(ephemerideData);
            //Gère les headers
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Access-Control-Allow-Origin", "https://pjvilloud.github.io");
            int statusCode = 200;
            //Renvoie de l'objet à API Gateway
            return new GatewayResponse(body, headers, statusCode);
        } catch (IOException e) {
            //Gère correctement l'exception
            e.printStackTrace();
        }

        return null;
    }
}
