package com.webcheckers.ui;

import com.webcheckers.appl.CheckerCentre;
import com.webcheckers.model.*;
import spark.*;



public class PostValidateMove implements Route {

    private final CheckerCentre checkerCentre;

    PostValidateMove(final CheckerCentre checkerCentre) {
        this.checkerCentre = checkerCentre;
    }

    @Override
    public Object handle(Request request, Response response) {
        ManageGame game = checkerCentre.getCurrentGame(request.session().attribute("username"));
        Board board = game.getBoard();
        String data = request.body();
        Move move = JsonUtils.fromJson(data, Move.class);
        Message message = board.validateMove(move);
        if(!message.getType().equals("error")) {
            game.addMoveToList(move);
            game.removePieceIfCaptured(move);
            board.movePiece(move);
        }
        return message;
    }
}
