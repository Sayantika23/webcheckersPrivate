package com.webcheckers.model;

import org.junit.Test;
import spark.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BoardTest {

    private Position Start= new Position(2,1);
    private Position End= new Position(2,2);
    private Position Start2= new Position (2,1);
    private Position  End2= new Position(3,2);
    private Position start3= new Position (6,7);
    private Position End3= new Position (5,6);
    private Position start4= new Position (5,2);
    private Position End4= new Position (4,1);
    private Position start5= new Position (6,7);
    private Position End5= new Position (4,3);

    private List<Row> ROWS = new ArrayList<Row>();
    private String Player1= "Fasaiel";
    private String Player2="Ali";
    private Player P1= new Player(Player1);
    private Player P2= new Player(Player2);
    private Session session1= mock(Session.class);
    private Session session2= mock(Session.class);

    @Test
    public void Board()
    {
        Board board= new Board();
        Iterator<Row> iter1= board.getRows().iterator();
        for (int i=0; i<=7; i++)
        {
            int rowId= iter1.next().getIndex();
            assertEquals(i, rowId);
        }
    }

    @Test
    public void testSetRows()
    {
        Board board=new Board();
        board.setRows(ROWS);
        assertNotNull(board.getRows());
    }


    @Test
    public void testGetRows() {
        Board board = new Board();
        assertNotNull(board.getRows());

    }

    public void testIterator()
    {
        Board board = new Board();
        assertNotNull(board.iterator());
    }












}