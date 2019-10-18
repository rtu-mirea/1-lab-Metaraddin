package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CCode {
    private ArrayList<String> codeLines;

    public CCode(String directory) throws IOException {
        codeLines = new ArrayList<String>();
        String code = new String(Files.readAllBytes(Paths.get(directory)));
        for (String retval : code.split("\n")) {
            codeLines.add(retval);
        }
    }

    public int findCountNewObject() {
        int result = 0;
        for (String line : codeLines) {
            if (line.indexOf("new") != -1) { result++; }
        }
        return result;
    }

    public String findAllNewObject() {
        String result = "";
        Pattern pattern = Pattern.compile("[a-zA-Z]+\\s*=\\s*new\\s+[a-zA-Z]+\\s*(\\s*)");
        for (String line : codeLines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String temp = line.substring(matcher.start(), matcher.end());
                matcher = Pattern.compile("[a-zA-Z]+").matcher(temp);
                matcher.find();
                result += temp.substring(matcher.start(), matcher.end());
                temp = temp.substring(matcher.end() + 2).trim().substring(3).trim();
                result += " (" + temp + ")\n";
            }
        }
        return result;
    }

    public String findInputVariables() {
        String result = "";
        for (String line : codeLines) {
            if (line.indexOf(".next") != -1) {
                String temp = line.substring(0, line.indexOf("=")).trim();
                int ind = temp.indexOf(" ");
                while (ind != -1) {
                    temp = temp.substring(ind).trim();
                    ind = temp.indexOf(" ");
                }
                result += temp + "\n";
            }
        }
        return result;
    }

    public int findFinalCount() {
        int result = 0;
        for (String line : codeLines) {
            if (line.indexOf("final") != -1) {
                result++;
            }
        }
        return result;
    }

}
