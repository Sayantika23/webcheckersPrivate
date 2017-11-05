package com.webcheckers.appl;

import java.util.*;

import com.webcheckers.model.ManageGame;
import com.webcheckers.model.Player;
import com.webcheckers.ui.PlayerListRoute;

public class CheckerCentre {

    public Map<String, Player> getPlayers() {
        return players;
    }

    private Map<String, Player> players = new HashMap<>();

    public List<ManageGame> getGames() {
        return games;
    }

    private List<ManageGame> games = new ArrayList<>();


    public ManageGame getCurrentGame(String _username) {
        for(ManageGame game : games) {
            if(game.getFirstPlayer().getUsername().equals(_username) || game.getSecondPlayer().getUsername().equals(_username)) {
                return game;
            }
        }
        return null;
    }
    public List<String> getAvailablePlayers() {
        List<String> available = new ArrayList<>();
        CheckerCentre checkerCentre = new CheckerCentre();
        PlayerListRoute list = new PlayerListRoute(checkerCentre);
        for(String username : players.keySet()) {
            if(!list.InGameCheck(username,checkerCentre ))
                available.add(username);
        }
        return available;
    }


}