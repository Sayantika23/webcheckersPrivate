package com.webcheckers.model;

import java.util.ArrayList;
import java.util.List;

public class ManageGame {

    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;
    int turn;

    private List<Move> moves = new ArrayList<Move>();
    private List<Piece> capturedPieces = new ArrayList<Piece>();


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

    public int changeTurn() {
        this.turn = (this.turn == 0) ? 1 : 0;
        this.board.setDidMove(false);
        this.board.setDidJump(false);
        moves.clear();
        return this.turn;
    }

    public Message backupMove() {
        if(moves.size() > 0) {
            int lastMovePosition = moves.size() - 1;
            Move moveToUndo = moves.get(lastMovePosition);
            moves.remove(lastMovePosition);

            board.undoMove(moveToUndo);

            if(moveToUndo.getRowsMoved() == 2) {
                int lastPieceCapturedPosition = capturedPieces.size() - 1;
                Position jumpedCoordinate = moveToUndo.getJumpedCoordinate();
                Space jumpedSpace = board.getSpaceByCoordinate(jumpedCoordinate);
                Piece pieceToRestore = capturedPieces.get(lastPieceCapturedPosition);

                capturedPieces.remove(lastPieceCapturedPosition);
                board.undoCapture(jumpedSpace, pieceToRestore, capturedPieces.size());
            }

            return new Message("Move has been undone!", "info");
        } else {
            return new Message("No moves have been made!", "error");
        }
    }

    public void addMoveToList(Move move) {
        moves.add(move);
    }

    public void removePieceIfCaptured(Move _move) {
        if(_move.getRowsMoved() == 2) { //Verify that the move was a jump
            Position jumpedCoordinate = _move.getJumpedCoordinate();
            Space jumpedSpace = board.getSpaceByCoordinate(jumpedCoordinate);
            Piece jumpedPiece = jumpedSpace.getPiece();

            if(jumpedPiece != null) { //If a piece was captured,
                capturedPieces.add(jumpedPiece);
            }
        }
    }

}
