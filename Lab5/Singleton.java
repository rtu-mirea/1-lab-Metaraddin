package com.company;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        songsList =  new SongsList();
        userList = new UserList();
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    private SongsList songsList;
    private UserList userList;
    private User currentUser;

    public SongsList getSongsList() { return songsList; }
    public UserList getUserList() { return userList; }
    public User getCurrentUser() { return currentUser; }
}