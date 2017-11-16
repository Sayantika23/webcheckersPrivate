package com.webcheckers.model;

public class Move {


    private Position start;
    private Position end;

    public Move(Position start, Position end) {
        this.start = start;
        this.end = end;
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    public int getRowsMoved() {
        return Math.abs(start.getRow() - end.getRow());
    }


    public boolean isMoveUp() {
        return end.getRow() > start.getRow();
    }


    public Position getPosition() {
        int rowVal = (start.getRow() + end.getRow())/2;
        int cellVal = (start.getCell() + end.getCell())/2;

        return new Position(rowVal, cellVal);
    }

    public String toString() {
        return "Move: (Initial - R: " + start.getRow() + ", C: " + start.getCell() + ", Ending - R: " + end.getRow() + ", C: " + end.getCell() + ")";
    }

}