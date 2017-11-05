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
        Message message = validateMove(move, board);
        if(!message.getType().equals("error")) {
            board.movePiece(move);
        }
        return message;
    }

    public Message validateMove(Move move, Board board) {
        int startRow = move.getStart().getRow();
        int startCell = move.getStart().getCell();
        int endRow = move.getEnd().getRow();
        int endCell = move.getEnd().getCell();

        Space startSpace = board.getRows().get(startRow).getSpaces().get(startCell);
        Space endSpace = board.getRows().get(endRow).getSpaces().get(endCell);
        Piece piece = startSpace.getPiece();

        if(!board.isMove()) {
            if(endSpace.getPiece() == null) {
                if (piece.getColor().equals("RED")) {
                    if (endRow == startRow - 1) {
                        return new Message("Move Allowed", "info");
                    } else {
                        return new Message("Only 1 row can be used to move", "error");
                    }
                } else if (piece.getColor().equals("WHITE")) {
                    if (endRow == startRow + 1) {
                        return new Message("Move Allowed", "info");
                    } else {
                        return new Message("Only 1 row can be used to move", "error");
                    }
                }
            }
        }
        return new Message("Illegal Move", "error");
    }


}
