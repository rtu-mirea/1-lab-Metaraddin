package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //CCode test = new CCode("code.txt");
        //System.out.println(test.findAllNewObject());
        //System.out.println(test.findCountNewObject());
        //System.out.println(test.findInputVariables());
        //System.out.println(test.findFinalCount());

        //CText test2 = new CText("text.txt");
        //test2.deleteWords(1);
        //test2.deleteWords(3);
        //test2.insertWord(2, 1, "test");
        //System.out.println(test2.print());
        //CNumbers test3 = new CNumbers("numbers.txt");
        //System.out.println(test3.print());
        //test3.convert();
        //System.out.println(test3.print());
        menu();
    }

    public static void menu() throws IOException {
        int task = -1;
        while (task != 0) {
            System.out.println("Task N: ");
            Scanner scan = new Scanner(System.in);
            task = scan.nextInt();
            switch (task) {
                case (1):
                    CCode test = new CCode("code.txt");
                    System.out.println(test.findAllNewObject());
                    System.out.println(test.findCountNewObject());
                    System.out.println(test.findInputVariables());
                    System.out.println(test.findFinalCount());
                    break;
                case (2):
                    CText test2 = new CText("text.txt");
                    test2.deleteWords(1);
                    test2.deleteWords(3);
                    test2.insertWord(2, 1, "test");
                    System.out.println(test2.print());
                    break;
                case (3):
                    CNumbers test3 = new CNumbers("numbers.txt");
                    System.out.println(test3.print());
                    test3.convert();
                    System.out.println(test3.print());
                    break;
                default:
                    break;
            }
        }
    }
}
