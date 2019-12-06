package com.company;

import java.util.ArrayList;

public class Song {
    private String name;
    private ArrayList<User> vote;

    public Song(String nameInp) {
        name = nameInp;
        vote = new ArrayList<User>();
    }

    public boolean checkUser(User inp) {
        for (User user : vote) {
            if (user.getName().equals(inp.getName())) {
                return false;
            }
        }
        return true;
    }

    public Song() {
        name = "None";
        vote = new ArrayList<User>();
    }

    public String getName() { return name; }
    public int getVote() { return vote.size(); }
    public void toVote(User inp) { vote.add(inp); }
}
