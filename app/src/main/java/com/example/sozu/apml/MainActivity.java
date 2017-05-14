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


public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView textElement;
    private TextView textElement2;
    private Sensor mySensor;
    private SensorManager SM;
    private ArrayList<XYZ>Datos;
    final double alpha = 0.99;
    double[] gravity;
    double[] linear_acceleration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textElement = (TextView) findViewById(R.id.texto);
        textElement2 = (TextView) findViewById(R.id.texto2);
        textElement.setText("");

        gravity = new double[3];
        linear_acceleration = new double[3];
        for (int i = 0; i<3; i++)
            gravity[i] = 0.0;

        //Create our Sensor Manager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);

        //Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        Datos = new ArrayList<>();
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
        Datos.clear();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
        gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
        gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];

        linear_acceleration[0] = event.values[0] - gravity[0];
        linear_acceleration[1] = event.values[1] - gravity[1];
        linear_acceleration[2] = event.values[2] - gravity[2];

        //Datos.add(new XYZ(0,9,0));
        Datos.add(new XYZ(linear_acceleration[0]*100000000000000.0, linear_acceleration[1]*100000000000000.0, linear_acceleration[2]*100000000000000.0));
        textElement2.setText("X: "+linear_acceleration[0]+"\nY: "+linear_acceleration[1]+"\nZ: "+linear_acceleration[2]);

        //Calculo con gravedad eliminada
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //No es necesaria
    }
}
