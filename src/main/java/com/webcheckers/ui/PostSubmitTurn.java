package com.webcheckers.ui;

import com.webcheckers.appl.CheckerCentre;
import com.webcheckers.model.ManageGame;
import spark.Request;
import spark.Response;
import spark.Route;


import static spark.Spark.halt;

public class PostSubmitTurn implements Route {

    private final CheckerCentre checkerCentre;

    PostSubmitTurn(final CheckerCentre checkerCentre) {
        this.checkerCentre = checkerCentre;
    }

    @Override
    public Object handle(Request request, Response response) {
        System.out.println(request.body());
        ManageGame game = checkerCentre.getCurrentGame(request.session().attribute(PostLoginRoute.USERNAME_PARAM));
        response.redirect("/game");
        halt();
        return null;
    }
}


