package com.example.sozu.apml;

import android.provider.ContactsContract;

import org.jtransforms.fft.DoubleFFT_3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Math.abs;

/**
 * Created by sozu on 12/05/2017.
 */

public class FuncionesMat {

    private ArrayList<XYZ> Data;
    Comparador Comp;
    public FuncionesMat(ArrayList<XYZ> xyz){
        Data = new ArrayList<>(xyz);
    }

    public double meanX(){
        double mX = 0;
        for(XYZ t : Data)
            mX += t.X();
        return mX/Data.size();
    }

    public double meanY(){
        double mX = 0;
        for(XYZ t : Data)
            mX += t.Y();
        return mX/Data.size();
    }

    public double meanZ(){
        double mX = 0;
        for(XYZ t : Data)
            mX += t.Z();
        return mX/Data.size();
    }

    public double meanMag(){
        double mX = 0;
        for(XYZ t : Data)
            mX += t.Mag();
        return mX/Data.size();
    }

    public double medianX(){
        Comp = new ComparadorX();
        Collections.sort(Data, (Comparator<? super XYZ>) Comp);
        int median = Data.size()/2;
        if(median%2 == 1) return Data.get(median).X();
        else return (Data.get(median-1).X()+Data.get(median).X())/2;
    }

    public double medianY(){
        Comp = new ComparadorY();
        Collections.sort(Data, (Comparator<? super XYZ>) Comp);
        int median = Data.size()/2;
        if(median%2 == 1) return Data.get(median).Y();
        else return (Data.get(median-1).Y()+Data.get(median).Y())/2;
    }

    public double medianZ(){
        Comp = new ComparadorZ();
        Collections.sort(Data, (Comparator<? super XYZ>) Comp);
        int median = Data.size()/2;
        if(median%2 == 1) return Data.get(median).Z();
        else return (Data.get(median-1).Z()+Data.get(median).Z())/2;
    }

    public double medianMag(){
        Comp = new ComparadorMag();
        Collections.sort(Data, (Comparator<? super XYZ>) Comp);
        int median = Data.size()/2;
        if(median%2 == 1) return Data.get(median).Mag();
        else return (Data.get(median-1).Mag()+Data.get(median).Mag())/2;
    }

    public double maxX(){
        double maximo = 0;
        for(XYZ t : Data)
            maximo = Math.max(maximo, t.X());
        return maximo;
    }

    public double maxY(){
        double maximo = 0;
        for(XYZ t : Data)
            maximo = Math.max(maximo, t.Y());
        return maximo;
    }

    public double maxZ(){
        double maximo = 0;
        for(XYZ t : Data)
            maximo = Math.max(maximo, t.Z());
        return maximo;
    }

    public double maxMag(){
        double maximo = 0;
        for(XYZ t : Data)
            maximo = Math.max(maximo, t.Mag());
        return maximo;
    }

    public double minX(){
        double minimo = Data.get(0).X();
        for(XYZ t : Data)
            minimo= Math.min(minimo, t.X());
        return minimo;
    }

    public double minY(){
        double minimo = Data.get(0).Y();
        for(XYZ t : Data)
            minimo= Math.min(minimo, t.Y());
        return minimo;
    }

    public double minZ(){
        double minimo = Data.get(0).Z();
        for(XYZ t : Data)
            minimo= Math.min(minimo, t.Z());
        return minimo;
    }

    public double minMag(){
        double minimo = Data.get(0).Mag();
        for(XYZ t : Data)
            minimo= Math.min(minimo, t.Mag());
        return minimo;
    }

    public double stdX() {
        double var = 0;
        double med = meanX();
        for (XYZ t : Data)
            var += Math.pow(t.X()-med, 2);
        return Math.sqrt(var/Data.size());
    }

    public double stdY() {
        double var = 0;
        double med = meanY();
        for (XYZ t : Data)
            var += Math.pow(t.Y()-med, 2);
        return Math.sqrt(var/Data.size());
    }

    public double stdZ() {
        double var = 0;
        double med = meanZ();
        for (XYZ t : Data)
            var +=  Math.pow(t.Z()-med, 2);
        return Math.sqrt(var/Data.size());
    }

    public double stdMag() {
        double var = 0;
        double med = meanMag();
        for (XYZ t : Data)
            var += Math.pow(t.Mag()-med, 2);
        return Math.sqrt(var/Data.size());
    }

    public double madX(){
        ArrayList<Double> medians = new ArrayList<>();
        double med = medianX();

        for(XYZ t : Data)
            medians.add(abs(t.X() - med));

        Collections.sort(medians);
        int median = medians.size()/2;
        if(median%2 == 1) return medians.get(median);
        else return (medians.get(median-1)+medians.get(median))/2;
    }

    public double madY(){
        ArrayList<Double> medians = new ArrayList<>();
        Comp = new ComparadorY();
        double med = medianY();

        for(XYZ t : Data)
            medians.add(abs(t.Y() - med));

        Collections.sort(medians);
        int median = medians.size()/2;
        if(median%2 == 1) return medians.get(median);
        else return (medians.get(median-1)+medians.get(median))/2;
    }

    public double madZ(){
        ArrayList<Double> medians = new ArrayList<>();
        Comp = new ComparadorZ();
        double med = medianZ();

        for(XYZ t : Data)
            medians.add(abs(t.Z() - med));

        Collections.sort(medians);
        int median = medians.size()/2;
        if(median%2 == 1) return medians.get(median);
        else return (medians.get(median-1)+medians.get(median))/2;
    }

    public double madMag(){
        ArrayList<Double> medians = new ArrayList<>();
        Comp = new ComparadorMag();
        double med = medianMag();

        for(XYZ t : Data)
            medians.add(abs(t.Mag() - med));

        Collections.sort(medians);
        int median = medians.size()/2;
        if(median%2 == 1) return medians.get(median);
        else return (medians.get(median-1)+medians.get(median))/2;
    }

    public double sma(){
        double magnitud = 0;
        for(XYZ t : Data)
            magnitud = magnitud + abs(t.X()) + abs(t.Y()) + abs(t.Z());
        return magnitud/3;
    }

    public double smaMag(){
        double magnitud = 0;
        for(XYZ t : Data)
            magnitud = magnitud + abs(t.Mag());
        return magnitud/3;
    }

    public double energyX(){
        double e = 0;
        for (XYZ t : Data)
            e+= Math.pow(t.X(),2);
        return e/Data.size();
    }

    public double energyY(){
        double e = 0;
        for (XYZ t : Data)
            e=+ Math.pow(t.Y(),2);
        return e/Data.size();
    }

    public double energyZ(){
        double e = 0;
        for (XYZ t : Data)
            e=+ Math.pow(t.Z(),2);
        return e/Data.size();
    }

    public double energyMag(){
        double e = 0;
        for (XYZ t : Data)
            e=+ Math.pow(t.Mag(),2);
        return e/Data.size();
    }

    public double IQRX() {
        return IQR(1);
    }

    public double IQRY() {
        return IQR(2);
    }

    public double IQRZ() {
        return IQR(3);
    }

    public double IQRMag() {
        return IQR(4);
    }

    public double entropyX(){
        double e=0;
        double Ci = 0;
        double Sj;
        for (XYZ t : Data){
            Sj = 0;
            for (XYZ j : Data)
                Sj+=j.X();
            Ci = t.X()/Sj;
            e+= Ci * Math.log(Ci);
        }
        return e;
    }

    public double entropyY(){
        double e=0;
        double Ci = 0;
        double Sj;
        for (XYZ t : Data){
            Sj = 0;
            for (XYZ j : Data)
                Sj+=j.Y();
            Ci = t.Y()/Sj;
            e+= Ci * Math.log(Ci);
        }
        return e;
    }

    public double entropyZ(){
        double e=0;
        double Ci = 0;
        double Sj;
        for (XYZ t : Data){
            Sj = 0;
            for (XYZ j : Data)
                Sj+=j.Z();
            Ci = t.Z()/Sj;
            e+= Ci * Math.log(Ci);
        }
        return e;
    }

    public double entropyMag(){
        double e=0;
        double Ci = 0;
        double Sj;
        for (XYZ t : Data){
            Sj = 0;
            for (XYZ j : Data)
                Sj+=j.Mag();
            Ci = t.Mag()/Sj;
            e+= Ci * Math.log(Ci);
        }
        return e;
    }

    public double[] arCoeffX(){
        double[] input = new double[Data.size()];
        for(int i=0;i<Data.size();i++)
            input[i] = Data.get(i).X();
        return calcMaxEntropy(input, 4);
    }

    public double[] arCoeffY(){
        double[] input = new double[Data.size()];
        for(int i=0;i<Data.size();i++)
            input[i] = Data.get(i).Y();
        return calcMaxEntropy(input, 4);
    }

    public double[] arCoeffZ(){
        double[] input = new double[Data.size()];
        for(int i=0;i<Data.size();i++)
            input[i] = Data.get(i).Z();
        return calcMaxEntropy(input, 4);
    }

    public double[] arCoeffMag(){
        double[] input = new double[Data.size()];
        for(int i=0;i<Data.size();i++)
            input[i] = Data.get(i).Mag();
        return calcMaxEntropy(input, 4);
    }

    private static double[] calcMaxEntropy(double[] inputseries, int degree){

        int length = inputseries.length;
        double[] per = new double[length+1];
        double[] pef = new double[length+1];
        double[] h = new double[degree+1];
        double[] g = new double[degree+2];
        double[] coef = new double[degree];
        double[][] ar = new double[degree+1][degree+1];

        double t1,t2;
        int n;

        for (n=1;n<=degree;n++) {

            double sn = 0.0;
            double sd = 0.0;
            int j;
            int jj = length - n;

            for (j=0;j<jj;j++) {
                t1 = inputseries[j+n] + pef[j];
                t2 = inputseries[j] + per[j];
                sn -= 2.0 * t1 * t2;
                sd += (t1 * t1) + (t2 * t2);
            }

            g[n] = sn / sd;
            t1 = g[n];

            if (n != 1) {
                for (j=1;j<n;j++){
                    h [j] = g [j] + t1 * g [n - j];
                }
                for (j=1;j<n;j++){
                    g[j] = h[j];
                }
                jj--;
            }

            for (j=0;j<jj;j++) {
                per [j] += t1 * pef [j] + t1 * inputseries [j + n];
                pef [j] = pef [j + 1] + t1 * per [j + 1] + t1 * inputseries [j + 1];
            }

            for (j = 0; j < n; j++)
                ar [n][j] = g [j + 1];
        }

        for (int i=0;i<degree;i++)
            coef[i] = -ar[degree][i];

        return coef;
    }

    private double IQR(int i){
        int tam = Data.size();
        if(tam%2 == 1){
            return median(tam/2, tam-1, i) - median(0, tam/2, i) ;
        }
        else return  median(tam/2, tam -1, i) - median(0, tam/2 -1, i);
    }

    private double median(int begin, int tam, int i) {
        int median = begin + (tam-begin)/2;
        switch (i) {
            case 1: Comp = new ComparadorX(); break;
            case 2: Comp = new ComparadorY(); break;
            case 3: Comp = new ComparadorZ(); break;
            case 4: Comp = new ComparadorMag(); break;
        }
        Collections.sort(Data, (Comparator<? super XYZ>) Comp);
        if(median%2 == 1){
            switch (i) {
                case 1: return Data.get(median).X();
                case 2: return Data.get(median).Y();
                case 3: return Data.get(median).Z();
                case 4: return Data.get(median).Mag();
            }
        }
        else{
            switch (i) {
                case 1: return (Data.get(median-1).X()+Data.get(median).X())/2;
                case 2: return (Data.get(median-1).Y()+Data.get(median).Y())/2;
                case 3: return (Data.get(median-1).Z()+Data.get(median).Z())/2;
                case 4: return (Data.get(median-1).Mag()+Data.get(median).Mag())/2;
            }
        }
        return 0;
    }
}
