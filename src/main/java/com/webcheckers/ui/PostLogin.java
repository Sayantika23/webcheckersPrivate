package com.webcheckers.ui;


import com.webcheckers.model.CurrentPlayers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

/**
 * PostLoginInController
 *
 * @author Sankarsh,Hiten,Girish,Fasaiel
 */

public class PostLogin implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        CurrentPlayers name = new CurrentPlayers(request.queryParams("username").toLowerCase(), true);
        if (CurrentPlayers.currentPlayers.contains(name)){
            vm.put("title", "Welcome!");
            vm.put("messageType", "error");
            return new ModelAndView(vm, "signin.ftl");
        }
        else {
            request.session().attribute("username", name.getName());
            CurrentPlayers.currentPlayers.add(name);
            vm.put("title", "Welcome!");
            vm.put("currentPlayer", true);
            vm.put("onlinePlayers", JsonUtils.toJson(CurrentPlayers.currentPlayers));
            vm.put("playerName", request.session().attribute("username"));
            return new ModelAndView(vm, "playerlist.ftl");
        }
    }
}
