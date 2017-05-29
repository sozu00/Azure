package com.example.sozu.apml;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Collections;

public class JsonReader {

    public String read(ArrayList<XYZ> xyz) {

        JSONParser parser = new JSONParser();

        try {
            getJson g;
            try {
               g = new getJson(xyz);
            }catch (Exception e){return "Error";}

            Object obj = parser.parse(g.get());
            JSONObject jsonObject = (JSONObject) obj;

            JSONObject Inputs = (JSONObject) jsonObject.get("Results");
            JSONArray array = (JSONArray) Inputs.get("output1");
            String resultado = "Error";
            JSONObject clase = (JSONObject)array.get(0);

            /*
            resultado= "Probabilidad andando: " +clase.get("Scored Probabilities for Class \"1\"");
            resultado= resultado+"\nProbabilidad Subiendo escaleras: " +clase.get("Scored Probabilities for Class \"2\"");
            resultado= resultado+"\nProbabilidad Bajando escaleras: " +(Double.parseDouble(""+clase.get("Scored Probabilities for Class \"3\""))-0.5);
            resultado= resultado+"\nProbabilidad quieto: " +clase.get("Scored Probabilities for Class \"4\"");
            */

            ArrayList<Double> Resultados = new ArrayList<>(4);
            Resultados.add(0, Double.parseDouble(""+clase.get("Scored Probabilities for Class \"1\"")));
            Resultados.add(1, Double.parseDouble(""+clase.get("Scored Probabilities for Class \"2\"")));
            Resultados.add(2, (Double.parseDouble(""+clase.get("Scored Probabilities for Class \"3\"")))-0.5);
            Resultados.add(3, Double.parseDouble(""+clase.get("Scored Probabilities for Class \"4\"")));
            int i = Resultados.indexOf(Collections.max(Resultados));

            switch (i) {
                case 0:
                    return "Andando";
                case 1:
                    return "Subiendo escaleras";
                case 2:
                    return "Bajando escaleras";
                case 3:
                    return "Sentado/Tumbado";
                default:
                    return resultado;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Error";
    }

}