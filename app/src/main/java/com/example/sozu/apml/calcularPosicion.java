package com.example.sozu.apml;

/**
 * Created by sozu on 29/05/2017.
 */

public class calcularPosicion {

    public static void calcPos() {
        Thread L = new lector();
        L.start();

        MainActivity.textElement.setText("Leyendo");
    }
}

class lector extends Thread{
    String t;
    JsonReader g;

    lector(){
        g = new JsonReader();
    }

    @Override
    public void run(){
        while(true) {
            try {
                this.sleep(1000);
                t = g.read(MainActivity.Datos);
                MainActivity.textElement.setText(t);
                MainActivity.Datos.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}