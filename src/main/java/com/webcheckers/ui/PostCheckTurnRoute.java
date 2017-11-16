package com.webcheckers.ui;

import com.webcheckers.appl.CheckerCentre;
import com.webcheckers.model.ManageGame;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

public class PostCheckTurnRoute implements Route {


    private final CheckerCentre checkercenter;
    private ManageGame game;

    PostCheckTurnRoute(final CheckerCentre checkercenter) {
        Objects.requireNonNull(checkercenter, "checkercenter must not be null");
        this.checkercenter = checkercenter;
    }



    public Object handle(Request request, Response response)  {
        final String currentUsername = request.session().attribute(PostLoginRoute.USERNAME_PARAM);
        game = checkercenter.getGame(currentUsername);

        if(game != null)
            return game.isMyTurn(currentUsername);
        else
            return false;
    }
}
