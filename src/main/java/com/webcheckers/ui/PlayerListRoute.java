package com.webcheckers.ui;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerListRoute implements TemplateViewRoute {

    public List retrievedlist = new ArrayList();

    @Override
    public ModelAndView handle(Request request, Response response) {

        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "hello");
        String RetrievedName =  request.queryParams("username");
        vm.put("username", RetrievedName);
        retrievedlist = PlayersAvailable.getPlayersAvailable();
        vm.put("playerList", retrievedlist);

        return new ModelAndView(vm,"playerlist.ftl");
    }
}
