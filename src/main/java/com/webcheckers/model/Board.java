package com.webcheckers.model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Board implements Iterable<Row>{

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    private List<Row> rows;



    private boolean Move = false;
    public boolean isMove() {
        return Move;
    }

    public Board() {
        rows = new ArrayList<>();
        for(int i=0; i<=7; i++) {
            rows.add(new Row(i));
        }
    }

    public void setMove(boolean move) {
        this.Move = move;
    }

    public void movePiece(Move move) {
        int startRow = move.getStart().getRow();
        int startCell = move.getStart().getCell();
        int endRow = move.getEnd().getRow();
        int endCell = move.getEnd().getCell();

        Space startSpace = rows.get(startRow).getSpaces().get(startCell);
        Space endSpace = rows.get(endRow).getSpaces().get(endCell);
        Piece piece = startSpace.getPiece();

        startSpace.setPiece(null);
        endSpace.setPiece(piece);
        Move = true;
    }

    @Override
    public Iterator<Row> iterator() {
        return rows.iterator();
    }

}