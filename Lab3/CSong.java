package com.company;

import java.util.ArrayList;

public class CSong {
    private String name;
    private ArrayList<CUser> vote;

    public CSong(String nameInp) {
        name = nameInp;
    }

    public CSong() {
        name = "None";
    }

    public String getName() { return name; }
    public int getVote() { return vote.size(); }
    public void toVote(CUser inp) { vote.add(inp); }
}
