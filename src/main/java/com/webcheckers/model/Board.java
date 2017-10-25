package com.webcheckers.model;
import java.util.*;


/**
 * Board Class.
 *
 */

public class Board implements Iterable<Row>{

    public List<Row> rows = new LinkedList<Row>(); //List of rows typecasted as linkedlist so that it stores value for all the lists available

    @Override
    public Iterator<Row> iterator()
    {
        return rows.iterator();
    }



    //Method to create the board
    public static Board createBoard(Board board) {

        //Iteration of rows
        int x = 0;
        while(x <= 7){
            board.rows.add(new Row(x));
            x++;
        }

        //Iteration of rows for the placement of pieces
        for (int m = 0; m <=7; m++) {
            //nested loop to find free spaces in the rows
            for (int n = 0; n <=7; n++) {
                board.rows.get(m).spaces.add(new Space(n, true));
            }
        }
        //loop to read rows incremently
        for (int m = 0; m <=7; m++) {
            //loop to check for spaces
            for (int n = 0; n <=7; n++) {
                if ( ((m == 0) || (m == 2)) && (n % 2 == 0)){
                    board.rows.get(m).spaces.get(n).piece = new Piece();
                    board.rows.get(m).spaces.get(n).piece.type = Piece.TYPE.SINGLE;
                    board.rows.get(m).spaces.get(n).piece.color = Piece.COLOR.WHITE;
                }
                if ( (m == 1) &&(n % 2 != 0) ){
                    board.rows.get(m).spaces.get(n).piece = new Piece();
                    board.rows.get(m).spaces.get(n).piece.type = Piece.TYPE.SINGLE;
                    board.rows.get(m).spaces.get(n).piece.color = Piece.COLOR.WHITE;
                }

                if ( ((m == 5) || (m == 7)) && (n % 2 != 0)){
                    board.rows.get(m).spaces.get(n).piece = new Piece();
                    board.rows.get(m).spaces.get(n).piece.type = Piece.TYPE.SINGLE;
                    board.rows.get(m).spaces.get(n).piece.color = Piece.COLOR.RED;

                }
                if ( (m == 6) && (n % 2 == 0) ){
                    board.rows.get(m).spaces.get(n).piece = new Piece();
                    board.rows.get(m).spaces.get(n).piece.type = Piece.TYPE.SINGLE;
                    board.rows.get(m).spaces.get(n).piece.color = Piece.COLOR.RED;
                }
            }
        }
        return board;
    }
}
