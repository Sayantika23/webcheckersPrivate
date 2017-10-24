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

/*@Test
public void testRedSinglePieceFalse(){
    final Piece CuT = new Piece();
    CuT.type = Piece.TYPE.KING;
    CuT.color = Piece.COLOR.RED;
    assertEquals(Piece.TYPE.SINGLE, CuT.getType());
    assertEquals(Piece.COLOR.RED, CuT.getColor());*/


//Single White Piece Test
@Test
public void testWhiteSinglePieceTrue(){
    final Piece CuT = new Piece();
    CuT.type = Piece.TYPE.SINGLE;
    CuT.color = Piece.COLOR.WHITE;
    assertEquals(Piece.TYPE.SINGLE, CuT.getType());
    assertEquals(Piece.COLOR.WHITE, CuT.getColor());
}

/*@Test
public void testWhiteSinglePieceFalse(){
    final Piece CuT = new Piece();
    CuT.type = Piece.TYPE.KING;
    CuT.color = Piece.COLOR.WHITE;
    assertEquals(Piece.TYPE.SINGLE, CuT.getType());
    assertEquals(Piece.COLOR.WHITE, CuT.getColor());
}*/

/*
// King Piece Test
@Test
    public void testRedKingPiece(){
    final Piece CuT = new Piece();
    CuT.type = Piece.TYPE.KING;
    CuT.color = Piece.COLOR.RED;
    assertEquals(Piece.TYPE.KING, CuT.getType());
    assertEquals(Piece.COLOR.RED, CuT.getColor());
}

@Test
public void testWhiteKingPiece(){
    final Piece CuT = new Piece();
    CuT.type = Piece.TYPE.KING;
    CuT.color = Piece.COLOR.WHITE;
    assertEquals(Piece.TYPE.KING, CuT.getType());
    assertEquals(Piece.COLOR.WHITE, CuT.getColor());
}
*/
}

