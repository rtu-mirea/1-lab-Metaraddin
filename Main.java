package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Java!\n");

        CVector vec1 = new CVector(23,11,4);
        CVector vec2 = new CVector();

        System.out.println(vec1.len());
        System.out.println(vec1.scalP(1,12,6) + "\n");

        System.out.println(vec1.print() + "\n");
        System.out.println(vec2.print());
    }
}