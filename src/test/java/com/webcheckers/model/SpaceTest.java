package com.webcheckers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class SpaceTest {


    private int cellIndex = 4;
    private String color = "black";
    private Piece piece;
    private Space CuT;


    @Before

    public void setPiece() throws Exception {
        piece = mock(Piece.class);
    }


    @Test
    public void get_piece() {
        CuT = new Space(color, piece, cellIndex);
        CuT.setPiece(piece);
        assertEquals(piece, CuT.getPiece());
    }


    @Test
    public void check_cellIndex() {
        CuT = new Space(color, piece, cellIndex);
        CuT.setCellIdx(cellIndex);
        assertEquals(cellIndex, CuT.getCellIdx());
    }

    @Test
    public void checkColor() {
        CuT = new Space(color, piece, cellIndex);
        CuT.setColor(color);
        assertEquals(color, CuT.getColor());
    }
    @Test
    public void invalid_move() {
        CuT = new Space(color, piece, cellIndex);
        CuT.setPiece(mock(Piece.class));
        assertFalse(CuT.isValid());
    }


}