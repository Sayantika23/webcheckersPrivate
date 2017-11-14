package com.webcheckers.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest
{

    private int Row=1;
    private int Col=1;
    private int Row2=2;
    private int Col2=2;

    @Test

   public void positionTest()
    {
        Position posit= new Position(Row,Col);
        assertNotNull(posit);

    }


    @Test
    public void rowTest()
    {
        Position posit = new Position(Row, Col);
        assertEquals(Row,posit.getRow());
    }

    @Test
    public void colTest()
    {
        Position posit = new Position(Row, Col);
        assertEquals(Col, posit.getCell());
    }

    @Test
    public void equalsTest()
    {
        Position pos = new Position(Row, Col);
        Position pos2 = new Position(Row, Col);
        assertTrue(pos.equals(pos2));
        pos2 = new Position(Row2, Col2);
        assertFalse(pos.equals(pos2));
    }

    @Test
    public void hashCodeTest()
    {
        Position pos1 = new Position(Row, Col);
        Position pos2 = new Position(Row,Col);
        if(pos1.equals(pos2)){
            assertTrue(pos1.hashCode() == pos2.hashCode());
        }
    }

}