package com.company;

import java.util.ArrayList;

public class CSong {
    private String name;
    private ArrayList<CUser> vote;

    public CSong(String nameInp) {
        name = nameInp;
        vote = new ArrayList<CUser>();
    }

    public boolean checkUser(CUser inp) {
        for (CUser user : vote) {
            if (user.getName().equals(inp.getName())) {
                return false;
            }
        }
        return true;
    }

    public CSong() {
        name = "None";
        vote = new ArrayList<CUser>();
    }

    public String getName() { return name; }
    public int getVote() { return vote.size(); }
    public void toVote(CUser inp) { vote.add(inp); }
}
