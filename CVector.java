package com.company;

public class CVector {
    private double _x;
    private double _y;
    private double _z;

    public CVector(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public double len () {
        return Math.sqrt(_x*_x + _y*_y + _z*_z);
    }

    public double scalP(double x, double y, double z) {
        return (_x*x + _y*y + _z*z);
    }
}
