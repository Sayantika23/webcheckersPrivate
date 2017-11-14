package com.webcheckers.model;
import org.junit.Test;

import static org.junit.Assert.*;

    public class MoveTest {

        private Position START = new Position(1, 1);
        private Position END = new Position(2, 2);
        private Position START2 = new Position(3, 3);
        private Position END2 = new Position(4, 4);


        @Test
        public void moveTest() {
            Move move = new Move(START, END);
            assertNotNull(move);
        }


        @Test
        public void startTest()
        {
            Move move = new Move(START, END);
            assertEquals(START, move.getStart());
        }

        @Test
        public void endTest() {
            Move move = new Move(START, END);
            assertEquals(END, move.getEnd());
        }

        @Test

            public void equalsTest() {
            Move move1 = new Move(START, END);
            Move move2 = new Move(START, END);
            move2 = new Move(START2, END2);
            assertFalse(move1.equals(move2));
        }

    }
