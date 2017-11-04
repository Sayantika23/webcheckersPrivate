package com.webcheckers.model;

import java.util.Objects;

public class Position {
    private int row;
    private int cell;

    public Position(int _row, int _cell) {
        this.row = _row;
        this.cell = _cell;
    }

    public int getRow() {
        return this.row;
    }

    public int getCell() {
        return this.cell;
    }

    @Override
    public boolean equals(Object pos) {
        if(pos == this) return true;
        if(!(pos instanceof Position)) return false;
        final Position that = (Position) pos;
        return this.row == that.row && this.cell == that.cell;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, cell);
    }
}
