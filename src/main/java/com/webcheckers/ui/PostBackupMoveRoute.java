package com.webcheckers.ui;

import com.webcheckers.appl.CheckerCentre;
import com.webcheckers.model.ManageGame;
import com.webcheckers.model.Message;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

public class PostBackupMoveRoute implements Route {

    //Attributes
    private final CheckerCentre gameCenter;

    PostBackupMoveRoute(final CheckerCentre gameCenter) {
        // validation
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");

        this.gameCenter = gameCenter;
    }

    @Override
    public Object handle(Request request, Response response) {
        final String currentUsername = request.session().attribute(PostLoginRoute.USERNAME_PARAM);
        ManageGame game = gameCenter.getGame(currentUsername);

        game.backupMove();

        return new Message("Move undone", "info");
    }
}
