package com.company;

import java.io.*;
import java.util.ArrayList;
import java.nio.charset.Charset;

public class TextTask {
    private ArrayList<String> pathes;

    public TextTask() {
        pathes = new ArrayList<String>();
    }

    public boolean newFile (String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean saveToFile (String path, String text) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(new File(path));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String readFromFile (String path) {
        String result = "";
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp;
            while((temp = bufferedReader.readLine()) != null) {
                result += temp;
            }
            bufferedReader.close();
            return result;
        }
        catch (Exception e) {
            return result;
        }
    }

    public boolean saveToFile128for512 (String path, String text) {
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "Cp1251");
            BufferedReader in = new BufferedReader(inputStreamReader);
            String line;
            System.out.println(Charset.defaultCharset().name());
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}