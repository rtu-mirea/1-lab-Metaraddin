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
                    "0 - Выход\n");
            boolean check = true;
            while (check) {
                System.out.println("Что Вы хотите сделать?: ");
                if (scan.hasNextInt()){
                    choice = scan.nextInt();
                }
                else{
                    System.out.println("Допускается только int.");
                    scan.next();
                    continue;
                }
                check = false;
            }
            if (choice == 1) {
                System.out.println(mas.print());
            }
            else if (choice == 2) {
                System.out.println(mas.printRev());
            }
            else if (choice == 3) {
                System.out.print("Введите N: ");
                mas.shift(scan.nextInt());
                System.out.println(mas.print());
            }
            else if (choice == 4) {
                mas.sort();
                System.out.println(mas.print());
            }
        }
    }

}