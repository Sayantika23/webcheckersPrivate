package com.webcheckers.ui;

import com.webcheckers.model.*;

import spark.TemplateViewRoute;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Game Controller
 *
 * @author Sankarsh,Hiten,Girish,Fasaiel
 */

public class GameController implements TemplateViewRoute {


    public ModelAndView handle(Request request, Response response) {


        String opponent = request.queryParams("opponent");
        String player = request.session().attribute("username");


        Map<String, Object> vm = new HashMap<>();

        int playerIndex = CurrentPlayers.currentPlayers.indexOf(new CurrentPlayers(player));
        int opponentIndex = CurrentPlayers.currentPlayers.indexOf(new CurrentPlayers(opponent));

        if (CurrentPlayers.currentPlayers.get(opponentIndex).isAvailabale()  ){
            vm.put("title","Game");
            vm.put("opponentName", request.queryParams("opponent"));
            vm.put("opponentColor", Piece.CEnum.WHITE);
            vm.put("playerName", request.session().attribute("username"));
            vm.put("playerColor", Piece.CEnum.RED);
            vm.put("isMyTurn", true);


            CurrentPlayers.currentPlayers.get(opponentIndex).setAvailable(false);
            CurrentPlayers.currentPlayers.get(playerIndex).setAvailable(false);

            Board board=  Board.createBoard( new Board());

            vm.put("board", board);
            return new ModelAndView(vm, "game.ftl");
        }
        else {
            vm.put("title","Game");
            vm.put("currentPlayer", true);
            vm.put("messageType", "error");
            vm.put("message", "The player already is in another game!");
            vm.put("playerName", request.session().attribute("username"));
            vm.put("onlinePlayers", JsonUtils.toJson(CurrentPlayers.currentPlayers));
            return new ModelAndView(vm, "home.ftl");
        }



    }
}
