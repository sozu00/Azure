package com.example.sozu.apml;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView textElement;
    private double tiempo = System.currentTimeMillis();
    public static int FrecuenciaDeseada = 5000;
    private Sensor mySensor;
    private SensorManager SM;
    public static ArrayList<XYZ>Datos;
    final double alpha = 0.99;
    double[] gravity;
    double[] linear_acceleration;
    GraphView graph;
    LineGraphSeries<DataPoint> seriesX;
    LineGraphSeries<DataPoint> seriesY;
    LineGraphSeries<DataPoint> seriesZ;
    private int LastX = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textElement = (TextView) findViewById(R.id.texto);
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

        graph = (GraphView) findViewById(R.id.graph);
        seriesX = new LineGraphSeries<>();
        seriesX.setColor(Color.GREEN);
        seriesY = new LineGraphSeries<>();
        seriesY.setColor(Color.RED);
        seriesZ = new LineGraphSeries<>();
        seriesZ.setColor(Color.BLUE);

        createGraph(graph, seriesX, "X");
        createGraph(graph, seriesY, "Y");
        createGraph(graph, seriesZ, "Z");
        SeekBar freQ = (SeekBar) findViewById(R.id.freQ);

        freQ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.FrecuenciaDeseada = progress+1000;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                TextView Freq = (TextView) findViewById(R.id.frecuencia);
                Freq.setText("cada "+String.valueOf(FrecuenciaDeseada/1000.0)+" segundos");
            }
        });
    }

    public void onPause() {
        //Detiene el acelerometro en caso de cerrar la APP, sino consume mucha bateria
        super.onPause();
        SM.unregisterListener(this);
    }
    public void onResume() {
        super.onResume();
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
        gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
        gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];

        linear_acceleration[0] = event.values[0] - gravity[0];
        linear_acceleration[1] = event.values[1] - gravity[1];
        linear_acceleration[2] = event.values[2] - gravity[2];

        /*En caso de que haya pasado menos de X segundos, sigue almacenando datos
        *Caso contrario hace la llamada a Azure para mostrar el estado de los ultimos X segundos
        */
        if(System.currentTimeMillis() - tiempo < FrecuenciaDeseada )
           Datos.add(new XYZ(linear_acceleration[0], linear_acceleration[1], linear_acceleration[2]));
        else {
            final String[] t = {""};
            Thread T = new Thread(new Runnable() {@Override public void run() {t[0] = new JsonReader().read(Datos);}});

            T.start();
            try {T.join();} catch (InterruptedException e) {e.printStackTrace();}

            textElement.setText(t[0]);
            Datos.clear();
            tiempo = System.currentTimeMillis();
        }
        //Calculo con gravedad eliminada
        LastX++;
        seriesX.appendData(new DataPoint(LastX, linear_acceleration[0]), true, 50);
        seriesY.appendData(new DataPoint(LastX, linear_acceleration[1]), true, 50);
        seriesZ.appendData(new DataPoint(LastX, linear_acceleration[2]), true, 50);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //No es necesaria
    }

    private void createGraph(GraphView graph, LineGraphSeries<DataPoint> series, String Col){
        series.setTitle(Col);
        graph.addSeries(series);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setScrollable(true);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-10);
        graph.getViewport().setMaxY(10);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(50);
        graph.getGridLabelRenderer().setGridColor(Color.BLACK);
        graph.getGridLabelRenderer().setHighlightZeroLines(false);
        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.BLACK);
        graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);

        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        graph.getGridLabelRenderer().reloadStyles();
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.BOTH);
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }


}

