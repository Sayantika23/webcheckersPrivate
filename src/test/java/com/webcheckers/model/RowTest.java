package com.webcheckers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RowTest {
    @Before
    public void setUp() throws Exception {

    }

    //checking the index is set or not
    @Test
    public void checkSameIndex(){
        Row row = new Row(1);
        assertEquals(1, row.getIndex());
    }
}