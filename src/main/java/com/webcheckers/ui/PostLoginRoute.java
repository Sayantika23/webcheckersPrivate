package com.webcheckers.ui;


import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostLoginRoute implements TemplateViewRoute{

    @Override
    public ModelAndView handle(Request request, Response response) {
        String name = request.queryParams("username");
        Map<String, Object> vm = new HashMap<>();

        //Check statement to read if the name is already in the file or not
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
