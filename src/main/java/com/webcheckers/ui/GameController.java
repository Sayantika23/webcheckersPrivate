package com.webcheckers.ui;

import java.util.*;

import com.webcheckers.appl.CheckerCentre;
import com.webcheckers.model.ManageGame;
import spark.*;

public class GameController implements TemplateViewRoute {

    //Constants
    public static final String PLAYER_NAME = "playerName";
    public static final String PLAYER_COLOR = "playerColor";
    public static final String MY_TURN = "isMyTurn";
    public static final String OPP_NAME = "opponentName";
    public static final String OPP_COLOR = "opponentColor";
    public static final String CURR_PLAYER = "currentPlayer";
    public static final String GAME_BOARD = "board";
    public static final String RED = "RED";
    public static final String WHITE = "WHITE";
    public static final String VIEW_NAME = "game.ftl";

    private final CheckerCentre checkerCentre;
    private ManageGame game;

    GameController(final CheckerCentre checkerCentre) {
        this.checkerCentre = checkerCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Play!");
        final Session session = request.session();
        final String currentUsername = session.attribute(PostLoginRoute.USERNAME_PARAM);
        game = checkerCentre.getCurrentGame(currentUsername);

        if(game.getFirstPlayer().getUsername().equals(currentUsername)) {
            vm.put(PLAYER_NAME, game.getFirstPlayer().getUsername());
            vm.put(PLAYER_COLOR, RED);
            vm.put(MY_TURN, true);
            vm.put(OPP_NAME, game.getSecondPlayer().getUsername());
            vm.put(OPP_COLOR, WHITE);
            vm.put(CURR_PLAYER, true);
        } else {
            vm.put(PLAYER_NAME, game.getSecondPlayer().getUsername());
            vm.put(PLAYER_COLOR, WHITE);
            vm.put(MY_TURN, false);
            vm.put(OPP_NAME, game.getFirstPlayer().getUsername());
            vm.put(OPP_COLOR, RED);
            vm.put(CURR_PLAYER, false);
        }

        vm.put(MY_TURN, game.isMyTurn(currentUsername));
        vm.put(GAME_BOARD, game.getBoard());


        return new ModelAndView(vm , VIEW_NAME);

    }

}