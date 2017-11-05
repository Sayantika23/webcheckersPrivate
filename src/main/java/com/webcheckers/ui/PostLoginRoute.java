package com.webcheckers.ui;


import com.webcheckers.appl.CheckerCentre;
import com.webcheckers.model.ManageGame;
import com.webcheckers.model.Player;
import spark.*;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

public class PostLoginRoute implements TemplateViewRoute{


    static final String USERNAME_PARAM = "username";

    private final CheckerCentre checkerCentre;


    PostLoginRoute(final CheckerCentre checkerCentre) {
        this.checkerCentre = checkerCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {

        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Login!");

        final Session session = request.session();
        final String Username = request.queryParams(USERNAME_PARAM);


        addplayer(request.session(), Username,checkerCentre);

        session.attribute(USERNAME_PARAM, Username);
        vm.put(USERNAME_PARAM, Username);
        vm.put("username", request.session().attribute("username"));
        vm.put(USERNAME_PARAM, Username);
        response.redirect("/playerlist");


        return new ModelAndView(vm,"playerlist.ftl");


    }


    public void addplayer(Session session, String username, CheckerCentre checkerCentre) {
        Player newPlayer = new Player(username);
        session.attribute("player", newPlayer);
        checkerCentre.getPlayers().put(username, new Player(username));
    }

}
