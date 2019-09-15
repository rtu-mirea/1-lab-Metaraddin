package com.company;

public class CVector {
    private double mX;
    private double mY;
    private double mZ;

    public CVector(double x, double y, double z) {
        mX = x;
        mY = y;
        mZ = z;
    }

    public CVector() {
        mX = 0;
        mY = 0;
        mZ = 0;
    }

    public double len() {
        return Math.sqrt(mX*mX + mY*mY + mZ*mZ);
    }

    public double scalP(double x, double y, double z) {
        return (mX*x + mY*y + mZ*z);
    }

    public String print() {
        return ("X: " + Double.toString(mX) +
                "\nY: " + Double.toString(mY) +
                "\nZ: " + Double.toString(mZ));
    }
}