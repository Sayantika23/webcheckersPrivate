package com.webcheckers.ui;

import com.webcheckers.appl.CheckerCentre;

import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GetLogoutRoute implements TemplateViewRoute{
    private final CheckerCentre checkerCentre ;


    GetLogoutRoute(final CheckerCentre checkerCentre) {
        // validation
        Objects.requireNonNull(checkerCentre, "gameCenter must not be null");
        this.checkerCentre = checkerCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Login!");

        final Session session = request.session();
        final String currentPlayer = session.attribute("username");
        checkerCentre.removePlayer(currentPlayer);

        vm.put("username", null);

        return new ModelAndView(vm , "home.ftl");
    }
}