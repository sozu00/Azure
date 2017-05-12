package com.example.sozu.apml;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView textElement;
    private double x, y, z;
    private Sensor mySensor;
    private SensorManager SM;
    private long tiempo;
    private ArrayList<XYZ>Datos;
    private boolean checked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textElement = (TextView) findViewById(R.id.texto);
        textElement.setText("Prueba");

        //Create our Sensor Manager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);

        //Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        Datos = new ArrayList<>(50);
    }

    public void calcPos(View v) {
        TextView textElement = (TextView) findViewById(R.id.texto);
        final String[] t = new String[1];
        Thread hilo = new Thread(new Runnable(){
            @Override
            public void run() {
                try  {
                    JsonReader g = new JsonReader();
                    t[0] = g.read(Datos);
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

    public void getData(View v) throws InterruptedException {
        tiempo = System.currentTimeMillis();
        for(int i=0; i < 50; i++) {
            if(!checked)Datos.add(i, new XYZ(x, y, z));
            else Datos.set(i, new XYZ(x, y, z));
            TimeUnit.MILLISECONDS.sleep(10);
        }
        checked = true;
        textElement.setText("getData OK");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = (event.values[0]);
        y = (event.values[1]);
        z =(event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //No es necesaria
    }
}
