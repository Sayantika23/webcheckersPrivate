package com.webcheckers.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ManageGameTest {

    private Board board_CuT=new Board();
    private Player PLAYER1_CuT;
    private Player PLAYER2_CuT;
    int turn_CuT;
    private Position START1;
    private Position END1;
    private Move move1;
    private Position START2;
    private Position END2;
    private Move move2;
    private List<Move> move_CuT = new ArrayList<Move>() ;
    ManageGame managegame_CuT =new ManageGame(PLAYER1_CuT,PLAYER2_CuT);
    Message message = new Message("Invalid Move","error");


    @Before
    public void setUp() throws Exception {

        PLAYER1_CuT = new Player("Sankarsh");
        PLAYER2_CuT = new Player("Girish");
        //Board board_CuT = new Board();
        START1 = new Position(5,1);
        END1 = new Position(3,2);
        move1 = new Move(START1, END1);
        START2 = new Position(4,2);
        END2 = new Position(3,1);
        move2 = new Move(START2, END2);
       // ManageGame managegame_CuT = new ManageGame(PLAYER1_CuT,PLAYER2_CuT);

        move_CuT.add(move1);
        move_CuT.add(move2);

    }






    @Test
    public void getBoard() throws Exception {
        assertNotNull(board_CuT);
    }

    @Test
    public void getFirstPlayer() throws Exception {
        assertNotNull(PLAYER1_CuT);
    }

    @Test
    public void getSecondPlayer() throws Exception {
        assertNotNull(PLAYER2_CuT);
    }

    @Test
    public void isMyTurn() throws Exception {

        assertNotNull(PLAYER1_CuT.getUsername());
        int result = (PLAYER1_CuT.getUsername().equals("Sankarsh")) ? 0 : 1;
        assertEquals(0,result);

    }


    @Test
    public void changeTurn() throws Exception {
        assertNotNull(turn_CuT);
    }

    @Test
    public void backupMove() throws Exception {

        assertTrue(move_CuT.size() > 0);
        move_CuT.add(move1);

        int lastMovePosition = move_CuT.size() - 1;
        move_CuT.add(move2);
        //assertNotNull(move_CuT.get(lastMovePosition).getStart());
        Move moveToUndo = move_CuT.get(lastMovePosition);
        assertNotNull(moveToUndo);
        assertNotNull(moveToUndo.getStart().getRow());
        assertNotNull(moveToUndo.getEnd().getRow());

        assertTrue(moveToUndo.getRowsMoved() == 2);
        assertNotNull(managegame_CuT.backupMove());

        Message msg = managegame_CuT.backupMove();
        assertEquals(message.getType(),msg.getType());

    }

    @Test
    public void addMoveToList() throws Exception {

        move_CuT.add(move1);
        assertTrue(move_CuT.size()>2);
    }

    @Test
    public void removePieceIfCaptured() throws Exception {

        int lastMovePosition = move_CuT.size() - 2;
        Move moveToUndo = move_CuT.get(lastMovePosition);
        assertTrue(moveToUndo.getRowsMoved() == 2);
    }

}