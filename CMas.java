package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CMas {
    private long[] mMas;

    CMas() {
        System.out.println("\nКак вводить массив? (0 - с клавиатуры, 1 - генератор):");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        final int LEN = 10;
        mMas = new long[LEN];

        if (choice == 0) {
            for (int i = 0; i < LEN; i++) {
                System.out.print("Элемент №" + Integer.toString(i) + ": ");
                mMas[i] = scan.nextLong();
            }
        }
        else if (choice == 1) {
            for (int i = 0; i < LEN; i++) {
                mMas[i] = (int) (Math.random() * (200)) - 100;
            }
        }
    }

    public String print() {
        return Arrays.toString(mMas);
    }

    public String printRev() {
        String res = "[" + Long.toString(mMas[mMas.length - 1]);
        for (int i = mMas.length - 2; i >= 0; i--) {
            res += ", " + Long.toString(mMas[i]);
        }
        return res + "]";
    }

    public void shift(int dis) {
        int len = mMas.length;
        long[] res = new long[len];
        System.arraycopy(mMas, dis, res, 0, len - dis);
        System.arraycopy(mMas, 0, res, len - dis, dis);
        mMas = res;
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
