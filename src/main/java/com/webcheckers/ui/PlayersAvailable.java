package com.webcheckers.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayersAvailable implements Serializable {

    //Name of the player
    public String username="";

    //Name of the opponent
    public String opponentName;

    //list of all Users
    public static List<String> playersAvailable = new ArrayList();

    public PlayersAvailable() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static List getPlayersAvailable() {
        return playersAvailable;
    }

    public String getOpponentName() {

        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public boolean addPlayer(String username){
        playersAvailable.add(username);
        return true;
    }
}
