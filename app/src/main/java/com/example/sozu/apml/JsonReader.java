package com.example.sozu.apml;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JsonReader {

    public String read() {

        JSONParser parser = new JSONParser();

        try {
            getJson g = new getJson();
            Object obj = parser.parse(g.get());
            JSONObject jsonObject = (JSONObject) obj;

            JSONObject Inputs = (JSONObject) jsonObject.get("Results");
            JSONArray array = (JSONArray) Inputs.get("output1");
            String resultado = "";
            for(Object n: array) {
                JSONObject clase = (JSONObject) n;
                resultado= resultado+"Probabilidad clase 1: " +clase.get("Scored Probabilities for Class \"1\"");
                resultado= resultado+"\nProbabilidad clase 2: " +clase.get("Scored Probabilities for Class \"2\"");
                resultado= resultado+"\nProbabilidad clase 3: " +clase.get("Scored Probabilities for Class \"3\"");
                resultado= resultado+"\nProbabilidad clase 4: " +clase.get("Scored Probabilities for Class \"4\"");
                resultado= resultado+"\nClase estimada: "+clase.get("CLASE");
            }
            return resultado;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Error";
    }

}