package com.webcheckers.model;
import com.webcheckers.appl.CheckerCentre;
import org.junit.Test;

import static org.junit.Assert.*;

    public class MoveTest {

        private Position START = new Position(1, 1);
        private Position END = new Position(2, 2);
        private Position START2 = new Position(3, 3);
        private Position END2 = new Position(4, 4);

        int rowVal = (START.getRow() + END.getRow())/2;
        int cellVal = (START.getCell() + END.getCell())/2;

        Position CuT = new Position(rowVal,cellVal);

        @Test
        public void getEndTest(){
            assertNotNull(END);
        }


        @Test
        public void moveTest() {
            Move move = new Move(START, END);
            assertNotNull(move);
        }


        @Test
        public void getstartTest()
        {
            assertNotNull(START);
        }

        @Test
        public void getRowsMovedTest(){
            assertNotNull(START.getRow() - END.getRow());
        }

        @Test
        public void isMoveUp(){
            assertTrue(END.getRow() > START.getRow());
        }

        @Test
        public void getJumpedCoordinateTest(){


        }


        @Test

            public void equalsTest() {
            Move move1 = new Move(START, END);
            Move move2 = new Move(START, END);
            move2 = new Move(START2, END2);
            assertFalse(move1.equals(move2));
        }

    }
