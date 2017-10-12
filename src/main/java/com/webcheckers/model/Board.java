package com.webcheckers.model;
import java.util.*;


/**
 * Board Class.
 *
 * @authors Sankarsh,Hiten,Girish,Fasaiel
 */

public class Board implements Iterable<Row>{
    public List<Row> rows = new LinkedList<Row>();
    @Override
    public Iterator<Row> iterator()
    {
        return rows.iterator();
    }



    public static Board createBoard(Board board) {

        int x = 0;
        while(x <= 7){
            board.rows.add(new Row(x));
            x++;
        }

        for (int m = 0; m <=7; m++) {
            for (int n = 0; n <=7; n++) {
                board.rows.get(m).spaces.add(new Space(n, true, null));
            }
        }
        for (int m = 0; m <=7; m++) {
            for (int n = 0; n <=7; n++) {
                if ( ((m == 0) || (m == 2)) && (n % 2 == 0)){
                    board.rows.get(m).spaces.get(n).piece = new Piece();
                    board.rows.get(m).spaces.get(n).piece.type = Piece.TEnum.SINGLE;
                    board.rows.get(m).spaces.get(n).piece.color = Piece.CEnum.WHITE;
                }
                if ( (m == 1) &&(n % 2 != 0) ){
                    board.rows.get(m).spaces.get(n).piece = new Piece();
                    board.rows.get(m).spaces.get(n).piece.type = Piece.TEnum.SINGLE;
                    board.rows.get(m).spaces.get(n).piece.color = Piece.CEnum.WHITE;
                }

                if ( ((m == 5) || (m == 7)) && (n % 2 != 0)){
                    board.rows.get(m).spaces.get(n).piece = new Piece();
                    board.rows.get(m).spaces.get(n).piece.type = Piece.TEnum.SINGLE;
                    board.rows.get(m).spaces.get(n).piece.color = Piece.CEnum.RED;

                }
                if ( (m == 6) && (n % 2 == 0) ){
                    board.rows.get(m).spaces.get(n).piece = new Piece();
                    board.rows.get(m).spaces.get(n).piece.type = Piece.TEnum.SINGLE;
                    board.rows.get(m).spaces.get(n).piece.color = Piece.CEnum.RED;
                }
            }
        }
        return board;
    }
}
