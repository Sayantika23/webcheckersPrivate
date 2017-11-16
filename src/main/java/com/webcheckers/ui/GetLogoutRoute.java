package com.webcheckers.ui;

import com.webcheckers.appl.CheckerCentre;

import com.webcheckers.model.ManageGame;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GetLogoutRoute implements TemplateViewRoute{
    private final CheckerCentre checkerCentre ;


    GetLogoutRoute(final CheckerCentre checkerCentre) {
        // validation
        Objects.requireNonNull(checkerCentre, "checkercenter must not be null");
        this.checkerCentre = checkerCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Login!");

        final Session session = request.session();
        final String currentPlayer = session.attribute("username");
        if(GameCheck(currentPlayer,checkerCentre )) {
            ManageGame game = checkerCentre.getGame(currentPlayer);
            game.changeTurn();
        }

        session.removeAttribute("username");
        
        checkerCentre.removePlayer(currentPlayer);

        vm.put("username", null);

        return new ModelAndView(vm , "home.ftl");
    }

    public boolean GameCheck(String username, CheckerCentre checkerCentre ) {
        for(ManageGame game : checkerCentre.getGames()) {
            if(game.getFirstPlayer().getUsername().equals(username) || game.getSecondPlayer().getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}