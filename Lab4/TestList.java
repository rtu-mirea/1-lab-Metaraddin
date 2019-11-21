package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

class Test {
    public int number;
    public String theme;
    public int questionsCount;
    public int difficulty;
    public int maximumScore;

    public Test(int number,
                String theme,
                int questionsCount,
                int difficulty,
                int maximumScore) {
        this.number = number;
        if (theme.length() > 20) { this.theme = theme.substring(0, 20); }
        else { this.theme = theme; }
        if (questionsCount <= 0) { this.questionsCount = 1; }
        else { this.questionsCount = questionsCount; }
        if (difficulty <= 0) { this.difficulty = 1; }
        else if (difficulty > 5) { this.difficulty = 5; }
        else { this.difficulty = difficulty; }
        if (maximumScore <= 0) { this.maximumScore = 1; }
        else if (maximumScore > this.questionsCount) { this.maximumScore = this.questionsCount; }
        else { this.maximumScore = maximumScore; }
    }

    public String print() {
        return "Number: " + number +
                "\nTheme: " + theme +
                "\nQuestions Count: " + questionsCount +
                "\nDifficulty: " + difficulty +
                "\nMaximum Score: " + maximumScore;
    }
}

public class TestList {
    private ArrayList<Test> testArrayList;

    public TestList() {
        testArrayList = new ArrayList<Test>();
    }

    public boolean addTest(Test test) {
        for (Test i : testArrayList) {
            if (i.number == test.number) {
                return false;
            }
        }
        testArrayList.add(test);
        return true;
    }

    public boolean removeTest(int ind) {
        if (ind < 0 || ind > testArrayList.size() - 1) {
            return false;
        }
        testArrayList.remove(ind);
        return true;
    }

    public int getMaximumScoreByNumber(int number) {
        for (Test i : testArrayList) {
            if (i.number == number) {
                return i.maximumScore;
            }
        }
        return -1;
    }

    public int getDifficultyByNumber(int number) {
        for (Test i : testArrayList) {
            if (i.number == number) {
                return i.difficulty;
            }
        }
        return -1;
    }

    public boolean saveToFileFos(String path) {
        String result = "";
        for (Test i : testArrayList) {
            result += i.number + ";"
                    + i.theme + ";"
                    + i.questionsCount + ";"
                    + i.difficulty + ";"
                    + i.maximumScore + ";\n";

        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path, false);
            fileOutputStream.write(result.getBytes());
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean saveToFileRaf(String path) {
        String result = "";
        for (Test i : testArrayList) {
            result += String.format("%-20s", i.number)
                    + String.format("%-20s", i.theme)
                    + String.format("%-20s", i.questionsCount)
                    + String.format("%-20s", i.difficulty)
                    + String.format("%-20s", i.maximumScore) + "\n";
        }
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.writeBytes(result);
            file.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public LinkedList<Test> readFromFileFis(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            LinkedList<Test> result = new LinkedList<Test>();
            String line = "";
            int byteValue;
            int number;
            String theme;
            int questionsCount;
            int difficulty;
            int maximumScore;
            while ((byteValue = fileInputStream.read()) != -1) {
                if ((char)byteValue != '\n') { line += (char)byteValue; }
                else {
                    int tempIndexFirst = line.indexOf(';');
                    number = Integer.parseInt(line.substring(0, tempIndexFirst));

                    int tempIndexLast = line.indexOf(';', tempIndexFirst + 1);
                    theme = line.substring(tempIndexFirst + 1, tempIndexLast);

                    tempIndexFirst = line.indexOf(';', tempIndexLast + 1);
                    questionsCount = Integer.parseInt(line.substring(tempIndexLast + 1, tempIndexFirst));

                    tempIndexLast = line.indexOf(';', tempIndexFirst + 1);
                    difficulty = Integer.parseInt(line.substring(tempIndexFirst + 1, tempIndexLast));

                    tempIndexFirst = line.indexOf(';', tempIndexLast + 1);
                    maximumScore = Integer.parseInt(line.substring(tempIndexLast + 1, tempIndexFirst));

                    result.add(new Test(number, theme, questionsCount, difficulty, maximumScore));
                    line = "";
                }
            }
            return result;
        } catch (Exception e) {
            return new LinkedList<Test>();
        }
    }

    public void saveAllFromList(LinkedList<Test> inputList) {
        for (Test i : inputList) {
            testArrayList.add(i);
        }
    }

    public void saveTaskFromList(LinkedList<Test> inputList) {
        if (inputList.size() < 1) { return; }
        testArrayList.add(inputList.get(0));
        int reference = inputList.get(0).difficulty;
        for (int i = 1; i < inputList.size(); i++) {
            if (inputList.get(i).difficulty == reference) {
                testArrayList.add(inputList.get(i));
            }
        }
    }

    public boolean editTaskFromFileRaf(String path, int difficulty) {
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            int position = 60;
            while (position < file.length()) {
                file.seek(position);
                file.writeBytes(String.format("%-20s", difficulty));
                position += 101;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String print() {
        String result = "";
        for (Test i : testArrayList) {
            result += i.print() + "\n\n";
        }
        return result;
    }
}
