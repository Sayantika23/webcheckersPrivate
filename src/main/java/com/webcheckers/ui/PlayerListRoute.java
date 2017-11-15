package com.webcheckers.ui;

import com.webcheckers.appl.CheckerCentre;
import com.webcheckers.model.ManageGame;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.*;

import static spark.Spark.halt;

public class PlayerListRoute implements TemplateViewRoute {

    private final CheckerCentre checkerCentre;
    public PlayerListRoute(final CheckerCentre checkerCentre) {
        this.checkerCentre = checkerCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {

        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "hello");

        if(GameCheck(request.session().attribute("username"),checkerCentre)) {
            response.redirect("/game");
            halt();
            return null;
        }
        vm.put("usernames", checkerCentre.getAvailablePlayers());
        if(request.session().attribute("username") != null) {
            vm.put("username", request.session().attribute("username"));
        }

        return new ModelAndView(vm,"playerlist.ftl");
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
