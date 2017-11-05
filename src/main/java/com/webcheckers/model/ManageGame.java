package com.webcheckers.model;

public class ManageGame {

    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;
    int turn;


    public ManageGame(Player firstPlayer, Player secondPlayer){
        this.board = new Board();
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.turn = 0;
    }




    public Board getBoard() {
        return board;
    }


    public Player getFirstPlayer() {
        return this.firstPlayer;
    }


    public Player getSecondPlayer() {
        return this.secondPlayer;
    }



    public boolean isMyTurn(String name) {
        int result = (firstPlayer.getUsername().equals(name)) ? 0 : 1;

        return result == this.turn;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ManageGame) {
            ManageGame game = (ManageGame)obj;
            return (game.firstPlayer.getUsername() == ((ManageGame) obj).firstPlayer.getUsername() && game.secondPlayer.getUsername() == ((ManageGame) obj).secondPlayer.getUsername());
        }
        return false;
    }


}
