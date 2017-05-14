package com.example.sozu.apml;

import java.util.Comparator;

/**
 * Created by sozu on 14/05/2017.
 */

public interface Comparador{
    int compare(XYZ a, XYZ b);
}
class ComparadorX implements Comparador, Comparator<XYZ>{
    @Override
    public int compare(XYZ a, XYZ b) {
        if (a.X() > b.X()) return 1;
        if (a.X() < b.X()) return -1;
        return 0;
    }
}

class ComparadorY implements Comparador, Comparator<XYZ>{
    public int compare(XYZ a, XYZ b) {
        if (a.Y() > b.Y()) return 1;
        if (a.Y() < b.Y()) return -1;
        return 0;
    }
}

class ComparadorZ implements Comparador, Comparator<XYZ>{
    @Override
    public int compare(XYZ a, XYZ b) {
        if (a.Z() > b.Z()) return 1;
        if (a.Z() < b.Z()) return -1;
        return 0;
    }
}

class ComparadorMag implements Comparador, Comparator<XYZ>{
    @Override
    public int compare(XYZ a, XYZ b) {
        if (a.Mag() > b.Mag()) return 1;
        if (a.Mag() < b.Mag()) return -1;
        return 0;
    }
}