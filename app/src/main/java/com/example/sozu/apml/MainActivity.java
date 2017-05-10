package com.example.sozu.apml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textElement = (TextView) findViewById(R.id.texto);

        Button B;
        B = (Button) findViewById(R.id.boton);

        B.setOnClickListener(MainActivity.this);

        textElement.setText("Prueba");
    }

    public void onClick(View v) {
        TextView textElement = (TextView) findViewById(R.id.texto);
        final String[] t = new String[1];
        Thread hilo = new Thread(new Runnable(){
            @Override
            public void run() {
                try  {
                    JsonReader g = new JsonReader();
                    t[0] = g.read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            hilo.start();
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textElement.setText(t[0]);
    }
}
