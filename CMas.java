package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class CMas {
    private long[] mMas;

    CMas() {
        Scanner scan = new Scanner(System.in);
        boolean check = true;
        int choice = -1;
        while (check) {
            System.out.println("\nКак вводить массив? (0 - с клавиатуры, 1 - генератор):");
            if (scan.hasNextInt()){
                choice = scan.nextInt();
            }
            else{
                System.out.print("Допускается только int.");
                scan.next();
                continue;
            }
            check = false;
        }

        final int LEN = 10;
        mMas = new long[LEN];

        if (choice == 0) {
            for (int i = 0; i < LEN; i++) {
                check = true;
                while (check){
                    System.out.print("Элемент №" + Integer.toString(i) + ": ");
                    if (scan.hasNextLong()){
                        mMas[i] = scan.nextLong();
                    }
                    else{
                        System.out.println("Допускается только long.");
                        scan.next();
                        continue;
                    }
                    check = false;
                }
            }
        }
        else if (choice == 1) {
            for (int i = 0; i < LEN; i++) {
                mMas[i] = (int) (Math.random() * (200)) - 100;
            }
        }
    }

    public String print() { return Arrays.toString(mMas); }

    public String printRev() {
        String res = "[" + Long.toString(mMas[mMas.length - 1]);
        for (int i = mMas.length - 2; i >= 0; i--) {
            res += ", " + Long.toString(mMas[i]);
        }
        return res + "]";
    }

    public void shift(int dis) {
        for (int i = 0; i <= dis/2; i++) {
            long temp = mMas[i];
            mMas[i] = mMas[dis - 1 - i];
            mMas[dis - 1 - i] = temp;
        }
        for (int i = 0; i <= (mMas.length - 1 - dis)/2; i++) {
            long temp = mMas[i + dis];
            mMas[i + dis] = mMas[mMas.length - 1 - i];
            mMas[mMas.length - 1 - i] = temp;
        }
        for (int i = 0; i <= (mMas.length - 1)/2; i++) {
            long temp = mMas[i];
            mMas[i] = mMas[mMas.length - 1 - i];
            mMas[mMas.length - 1 - i] = temp;
        }
    }

    public void sort() {
        int len = mMas.length;
        long[] res = new long[len];

        int j = 0;
        for (int i = 0; i < len; i++) {
            if (mMas[i] < 0) {
                res[j] = mMas[i];
                j++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (mMas[i] > 0) {
                res[j] = mMas[i];
                j++;
            }
        }
        mMas = res;
    }
}
