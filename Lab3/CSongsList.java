package com.company;

import java.util.ArrayList;

public class CSongsList {
    private ArrayList<CSong> songs;

    public CSongsList() {
        songs = new ArrayList<CSong>();
    }

    public String print() {
        String res = "";
        for (int i = 0; i < songs.size(); i++) {
            res += i + ") " + songs.get(i).getName();
        }
        return res;
    }

    public boolean vote(CUser inp, String song) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getName() == song) {
                songs.get(i).toVote(inp);
                return true;
            }
        }
        songs.add(new CSong(song));
        songs.get(songs.size()).toVote(inp);
        return false;
    }

    public String result(int len) {
        String res = "";
        int j = 1;
        while (!songs.isEmpty() | j <= len) {
            int reference = 0;
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getVote() > songs.get(reference).getVote()) {
                    reference = i;
                }
            }
            res += j + ") " + songs.get(reference).getName() + "\n";
            songs.remove(reference);
        }
        return res;
    }
}
