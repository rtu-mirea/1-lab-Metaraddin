package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CText {
    private StringBuilder text;

    public String print() { return  text.toString(); }

    public CText(String directory) throws IOException {
        text = new StringBuilder();
        text.append(new String(Files.readAllBytes(Paths.get(directory))));
        text.insert(0," ");
    }

    public void deleteWords(int sentenceNum) {
        int startFind = 0;
        for (int i = 0; i < sentenceNum - 1; i++) {
            startFind = text.indexOf(".", startFind) + 1;
        }
        for (int i = 0; i < 4; i++) {
            startFind = text.indexOf(" ", startFind) + 1;
        }
        //System.out.println(text.subSequence(startFind, text.indexOf(".", startFind)));
        text.delete(startFind, text.indexOf(".", startFind));
    }

    public void newSentence(String wordOne, String wordTwo) {
        text.append("" + wordOne + " " + wordTwo + ".");
    }

    public void insertWord(int sentenceNum, int wordNum, String word) {
        int startFind = 0;
        for (int i = 0; i < sentenceNum - 1; i++) {
            startFind = text.indexOf(".", startFind) + 1;
            //System.out.println(text.subSequence(startFind,text.length()));
        }
        for (int i = 0; i < wordNum + 1; i++) {
            startFind = text.indexOf(" ", startFind) + 1;
        }
        text.insert(startFind, word + " ");
    }
}
