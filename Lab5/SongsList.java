package com.company;

import java.util.ArrayList;

public class SongsList {
    private ArrayList<Song> songs;

    public SongsList() {
        songs = new ArrayList<Song>();
    }

    public String print() {
        String res = "";
        for (int i = 0; i < songs.size(); i++) {
            res += i + ") " + songs.get(i).getName() + " (" + songs.get(i).getVote() + ")\n";
        }
        return res;
    }

    public String vote(User inp, String song) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getName().equals(song)) {
                if (songs.get(i).checkUser(inp)) {
                    songs.get(i).toVote(inp);
                    return "You voted.";
                }
                else {
                    return "You have already voted.";
                }
            }
        }
        songs.add(new Song(song));
        songs.get(songs.size() - 1).toVote(inp);
        return "Your vote was first.";
    }

    public String result(int len) {
        if (len > songs.size()) { len = songs.size(); }
        String res = "";
        int j = 1;
        while (j <= len) {
            //System.out.println(!songs.isEmpty());
            int reference = 0;
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getVote() > songs.get(reference).getVote()) {
                    reference = i;
                }
            }
            //System.out.println(reference);
            res += j + ") " + songs.get(reference).getName() + "\n";
            j++;
            songs.remove(reference);
        }
        return res;
    }
}
