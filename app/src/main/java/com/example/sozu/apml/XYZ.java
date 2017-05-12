package com.example.sozu.apml;

/**
 * Created by sozu on 12/05/2017.
 */

public class XYZ {

    private double X, Y, Z, Mag;
    public XYZ(double X, double Y, double Z){
        this.X=X;
        this.Y=Y;
        this.Z=Z;
        Mag = Math.sqrt(Math.pow(X,2)+Math.pow(Y,2)+Math.pow(Z,2));
    }

    public double X(){return X;}
    public double Y(){return Y;}
    public double Z(){return Z;}
    public double Mag(){return Mag;}
}
