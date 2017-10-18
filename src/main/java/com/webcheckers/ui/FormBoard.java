package com.webcheckers.ui;

import com.webcheckers.model.Board;
import com.webcheckers.model.Piece;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class FormBoard implements TemplateViewRoute {

    public ModelAndView handle(Request request, Response response) {

        Map<String, Object> vm = new HashMap<>();

        vm.put("title","Game");
        vm.put("opponentName", request.queryParams("opponentName"));
        vm.put("opponentColor", Piece.COLOR.WHITE);
        vm.put("playerName", request.queryParams("username"));
        vm.put("playerColor", Piece.COLOR.RED);
        vm.put("isMyTurn", true);

        //object to call method for creating board
        Board board =  Board.createBoard( new Board());

        vm.put("board", board);
        return new ModelAndView(vm, "game.ftl");




    }
}
