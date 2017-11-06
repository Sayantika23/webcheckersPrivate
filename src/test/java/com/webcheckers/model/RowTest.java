package com.webcheckers.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class RowTest {
    private int TOTAL_ROWS = 8;


    @Test
    public void test_firstRow() {
        Row CuT = new Row(0);
        assertEquals(TOTAL_ROWS, CuT.getSpaces().size());

        assertEquals("white", CuT.getSpaces().get(0).getColor());
        assertEquals("black", CuT.getSpaces().get(1).getColor());
    }

    @Test
    public void test_secondRow() {
        Row CuT = new Row(1);
        assertEquals(TOTAL_ROWS, CuT.getSpaces().size());
        assertEquals("black", CuT.getSpaces().get(0).getColor());
        assertEquals("white", CuT.getSpaces().get(1).getColor());
    }

    @Test
    public void test_getIndex() {
        Row CuT = new Row(0);
        assertEquals(0, CuT.getIndex());
    }

}
