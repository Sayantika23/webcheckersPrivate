package com.webcheckers.ui;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostLoginRoute implements TemplateViewRoute{

    /*public static String LIST = "CurrentPlayers";*/

    //PlayersAvailable playersAvailable = new PlayersAvailable();

    @Override
    public ModelAndView handle(Request request, Response response) {
        String name = request.queryParams("username");
        Map<String, Object> vm = new HashMap<>();

        if(!PlayersAvailable.playersAvailable.contains(name)){
            PlayersAvailable.playersAvailable.add(name);
        }
        else{
            vm.put("title", "HEY");
            vm.put("errorMessage", "user name taken");
            return new ModelAndView(vm, "SignIn.ftl");
        }
        vm.put("title", "hey");
        response.redirect(String.format("/playerlist?username=%s",name));
        return new ModelAndView(vm,"playerlist.ftl");
    }
}
