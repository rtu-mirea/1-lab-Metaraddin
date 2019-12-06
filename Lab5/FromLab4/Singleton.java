package com.company;

public class Singleton {
    public static final Singleton SINGLETON = new Singleton();
    public TestList testList;

    private Singleton() {
        testList = new TestList();
    }
}