package com.company;

public class Main {

    public static void main(String[] args) {
	    TestList testList = new TestList();
	    testList.addTest(new Test(11, "theme22", 33, 44, 55));
        testList.addTest(new Test(1111, "theme2222", 3333, 4444, 5555));
        System.out.println(testList.saveToFileRaf("testRAF.txt"));
        System.out.println(testList.saveToFileRaf("testRAF2.txt"));
        System.out.println(testList.editTaskFromFileRaf("testRAF2.txt", 10));
    }
}
