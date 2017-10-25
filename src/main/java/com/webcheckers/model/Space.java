package com.webcheckers.model;

/**
 *
 *  Space class
 */


public class Space {

    public int cellIdx;
    public boolean isValid;
    public Piece piece;
    public Space(int cellIdx,boolean isValid) { this.cellIdx=cellIdx;this.isValid=isValid; }

    public int getCellIdx() {
        return cellIdx;
    }
    public void setCellIdx(int cellIdx) {
        this.cellIdx = cellIdx;
    }
    public boolean isValid() {
        return isValid;
    }
    public void setValid(boolean valid) { isValid = valid; }
    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
