package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CNumbers {
    private ArrayList<String> mas;
    private final String integer = "^[+|-]?\\d+$";
    private final String fractional = "^[+|-]?\\d+.\\d+$";

    public String print() {
        String result = "";
        for (String number : mas) {
            result += number + " ";
        }
        return result;
    }

    public CNumbers(String directory) throws IOException {
        mas = new ArrayList<String>();
        String temp = new String(Files.readAllBytes(Paths.get(directory)));
        for (String retval : temp.split("\n")) {
            mas.add(retval.trim());
        }
    }

    public String determineType(int ind) {
        Matcher matcher = Pattern.compile(integer).matcher(mas.get(ind));
        if (matcher.find()) { return "Integer"; }
        else {
            matcher = Pattern.compile(fractional).matcher(mas.get(ind));
            if (matcher.find()) { return "Fractional"; }
            else {
                return "Lol";
            }
        }
    }

    public void convert() {
        for (int i = 0; i < mas.size(); i++) {
            String type = determineType(i);
            if (type == "Integer") {
                try {
                    mas.set(i, String.valueOf((int)Math.pow(Integer.parseInt(mas.get(i)), 2)));
                } catch (NumberFormatException nfe) {
                    System.out.println("Lol2");
                }
            } else if (type == "Fractional") {
                mas.set(i, mas.get(i).substring(0, mas.get(i).indexOf(".")));
            }
        }
    }
}