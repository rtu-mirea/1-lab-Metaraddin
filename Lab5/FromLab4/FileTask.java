package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileTask {
    private ArrayList<String> pathes;

    public FileTask() {
        pathes = new ArrayList<String>();
    }

    public boolean newFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                pathes.add(path);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean newFolder(String path) {
        File file = new File(path);
        if (file.mkdir()) {
            pathes.add(path);
            return true;
        }
        return false;
    }

    public boolean checkFile(String path) {
        return new File(path).isFile();
    }

    public boolean checkFloder(String path) {
        return new File(path).isDirectory();
    }

    public String getName(String path) {
        return new File(path).getName();
    }

    public String getParent(String path) {
        return new File(path).getParent();
    }

    public String getAbsolutePath(String path) {
        return new File(path).getAbsolutePath();
    }

    public boolean findFile(String path) {
        return new File(path).exists();
    }

    public long getSize(String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                this.newFile(path);
            }
            return file.length();
        } catch (Exception e) {
            return -1;
        }
    }

    public String[] list(String path) {
        return new File(path).list();
    }

    public File[] listFiles(String path) {
        return new File(path).listFiles();
    }

    public String[] listFilesName(File[] files) {
        String[] result = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            result[i] = files[i].getName();
        }
        return result;
    }

    public int listFilesCountFolder(File[] files) {
        int result = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                result++;
            }
        }
        return result;
    }
}