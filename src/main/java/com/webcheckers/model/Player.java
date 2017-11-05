package com.webcheckers.model;


public class Player {

    private String username;



    public Player(String username) {
        this.username = username;
    }


    public String getUsername() {
        return this.username;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Player) {
            Player current = (Player)obj;
            return current.getUsername().equals(this.username);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }
}

