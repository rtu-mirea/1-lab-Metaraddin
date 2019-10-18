package com.company;

import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Java!\n");

        CVector vec1 = new CVector(23,11,4);
        CVector vec2 = new CVector();

        System.out.println(vec1.len());
        System.out.println(vec1.scalP(1,12,6) + "\n");

        System.out.println(vec1.print() + "\n");
        System.out.println(vec2.print());

        menu();
    }

    private static void menu(){
        Scanner scan = new Scanner(System.in);
        int choice = -1;

        CMas mas = new CMas();

        while (choice != 0) {
            System.out.print("\n1 - Вывод массива\n" +
                    "2 - Вывод массива с конца\n" +
                    "3 - Сдвиг влево на N\n" +
                    "4 - Сортировка\n" +
                    "0 - Выход\n" +
                    "Что Вы хотите сделать: ");
            choice = scan.nextInt();
            switch (choice) {
                case (1):
                    System.out.println(mas.print());
                    break;
                case (2):
                    System.out.println(mas.printRev());
                    break;
                case (3):
                    System.out.print("Введите N: ");
                    mas.shift(scan.nextInt());
                    System.out.println(mas.print());
                    break;
                case (4):
                    mas.sort(0);
                    System.out.println(mas.print());
                    break;
            }
        }
    }

}