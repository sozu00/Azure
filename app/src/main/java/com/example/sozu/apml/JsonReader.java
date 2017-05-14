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
            getJson g = new getJson(xyz);
            Object obj = parser.parse(g.get());
            JSONObject jsonObject = (JSONObject) obj;

            JSONObject Inputs = (JSONObject) jsonObject.get("Results");
            JSONArray array = (JSONArray) Inputs.get("output1");
            String resultado = "";
            for(Object n: array) {
                JSONObject clase = (JSONObject) n;
                resultado= resultado+"Probabilidad andando: " +clase.get("Scored Probabilities for Class \"1\"");
                resultado= resultado+"\nProbabilidad Subiendo escaleras: " +clase.get("Scored Probabilities for Class \"2\"");
                resultado= resultado+"\nProbabilidad Bajando escaleras: " +clase.get("Scored Probabilities for Class \"3\"");
                resultado= resultado+"\nProbabilidad quieto: " +clase.get("Scored Probabilities for Class \"4\"");
                resultado= resultado+"\nClase estimada: "+clase.get("CLASE");
                /*
                ArrayList<Double> Resultados = new ArrayList<>(4);
                Resultados.add(0, Double.parseDouble(""+clase.get("Scored Probabilities for Class \"1\"")));
                Resultados.add(1, Double.parseDouble(""+clase.get("Scored Probabilities for Class \"2\"")));
                Resultados.add(2, Double.parseDouble(""+clase.get("Scored Probabilities for Class \"3\"")));
                Resultados.add(3, Double.parseDouble(""+clase.get("Scored Probabilities for Class \"4\"")));

                for(int i=0;i<4;i++){
                    if(Resultados.get(i) == Collections.max(Resultados)) {
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
                                return "Error";
                        }
                    }
                }
               */
            }
            return resultado;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Error";
    }

}