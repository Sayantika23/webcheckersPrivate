package com.wecheckers.model;

import static org.junit.Assert.*;

import com.webcheckers.model.Piece;
import org.junit.Test;

/**
 * The Unit Test Class for the Piece
 * @author Girish Kumar
 */
public class PieceTest {

//Single Red Piece Test
@Test
public void testRedSinglePieceTrue(){
    final Piece CuT = new Piece();
    CuT.type = Piece.TYPE.SINGLE;
    CuT.color = Piece.COLOR.RED;
    assertEquals(Piece.TYPE.SINGLE, CuT.getType());
    assertEquals(Piece.COLOR.RED, CuT.getColor());
}


//Single White Piece Test
@Test
public void testWhiteSinglePieceTrue(){
    final Piece CuT = new Piece();
    CuT.type = Piece.TYPE.SINGLE;
    CuT.color = Piece.COLOR.WHITE;
    assertEquals(Piece.TYPE.SINGLE, CuT.getType());
    assertEquals(Piece.COLOR.WHITE, CuT.getColor());
}


}

