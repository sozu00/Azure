package com.example.sozu.apml;

import java.util.ArrayList;

/**
 * Created by sozu on 12/05/2017.
 */

public class FuncionesMat {

    private ArrayList<XYZ> Data;
    public FuncionesMat(ArrayList<XYZ> xyz){
        Data = new ArrayList<XYZ>(xyz);
    }

    public double meanX(){
        double mX = 0;
        for(int i = 0; i < Data.size(); i++){
            mX+= Data.get(i).X();
        }
        return (mX/Data.size());
    }

    public String meanY(){
        double mY = 0;
        for(int i = 0; i < Data.size(); i++){
            mY += Data.get(i).Y();
        }
        return  String.valueOf(mY/Data.size());
    }

    public String meanZ(){
        double mZ = 0;
        for(int i = 0; i < Data.size(); i++){
            mZ+=  Data.get(i).Z();
        }
        return  String.valueOf(mZ/Data.size());
    }


}
