package com.example.sozu.apml;

/**
 * Created by sozu on 14/05/2017.
 */

public interface Comparador{
    public int compare(XYZ a, XYZ b);
}
public class ComparadorX implements Comparador{
    @Override
    public int compare(XYZ a, XYZ b) {
        if (a.X() > b.X()) return 1;
        if (a.X() < b.X()) return -1;
        return 0;
    }
}

public class ComparadorY implements Comparador{
    public int compare(XYZ a, XYZ b) {
        if (a.Y() > b.Y()) return 1;
        if (a.Y() < b.Y()) return -1;
        return 0;
    }
}
}

public class ComparadorZ implements Comparador{
    @Override
    public int compare(XYZ a, XYZ b) {
        if (a.Z() > b.Z()) return 1;
        if (a.Z() < b.Z()) return -1;
        return 0;
    }
}
public class ComparadorMag implements Comparador{
    @Override
    public int compare(XYZ a, XYZ b) {
        if (a.Mag() > b.Mag()) return 1;
        if (a.Mag() < b.Mag()) return -1;
        return 0;
    }
}