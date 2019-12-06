package com.company;

public class Singleton {
    public static final Singleton SINGLETON = new Singleton();
    public SongsList songsList;
    public UserList userList;
    public User currentUser;

    private Singleton() {
        songsList = new SongsList();
        userList = new UserList();
    }
}