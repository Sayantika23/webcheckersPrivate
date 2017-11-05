package com.webcheckers.ui;

import java.util.*;

import com.webcheckers.appl.CheckerCentre;

import com.webcheckers.model.ManageGame;
import com.webcheckers.model.Player;
import spark.*;

public class GetStartGameRoute implements TemplateViewRoute {



    private final CheckerCentre checkerCentre;


    public GetStartGameRoute(final CheckerCentre checkerCentre) {
        this.checkerCentre = checkerCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Go!");
        final Session session = request.session();
        String firstPlayer =  session.attribute(PostLoginRoute.USERNAME_PARAM);
        String secondPlayer = request.queryParams("contendor");
        ManageGame game = GamePlay(firstPlayer, secondPlayer,checkerCentre);
        vm.put(GameController.PLAYER_NAME, firstPlayer);
        vm.put(GameController.PLAYER_COLOR, GameController.RED);
        vm.put(GameController.MY_TURN, true);
        vm.put(GameController.OPP_NAME, secondPlayer);
        vm.put(GameController.OPP_COLOR, GameController.WHITE);
        vm.put(GameController.CURR_PLAYER, true);
        vm.put(GameController.GAME_BOARD, game.getBoard());
        return new ModelAndView(vm, "game.ftl");

    }

    public ManageGame GamePlay(String firstPlayer, String secondPlayer, CheckerCentre checkerCentre) {
        Player player1 = checkerCentre.getPlayers().get(firstPlayer);
        Player player2 = checkerCentre.getPlayers().get(secondPlayer);
        ManageGame game = new ManageGame(player1, player2);
        checkerCentre.getGames().add(game);
        return game;
    }

}
