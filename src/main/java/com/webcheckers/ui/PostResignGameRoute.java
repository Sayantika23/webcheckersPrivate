package com.webcheckers.ui;

import com.webcheckers.appl.CheckerCentre;
import com.webcheckers.model.ManageGame;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.halt;

public class PostResignGameRoute implements TemplateViewRoute {


    private final CheckerCentre checkercenter;

    public PostResignGameRoute(CheckerCentre checkercenter) {
        Objects.requireNonNull(checkercenter, "checkercenter must not be null");
        this.checkercenter = checkercenter;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Welcome!");
        final String currentUsername = request.session().attribute(PostLoginRoute.USERNAME_PARAM);
        ManageGame game = checkercenter.getGame(currentUsername);

        if(game != null ) { //If the game exists and is over, remove the game from the list of games
            checkercenter.removeGame(game);
        }

        response.redirect("/playerlist");
        halt();
        return null;

    }
}
