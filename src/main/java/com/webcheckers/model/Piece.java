package com.webcheckers.model;


/**
 *
 *  Shows the type of piece on the borad for the CheckersGame
 */
public class Piece {

    public TYPE type;
    public COLOR color;

    public enum TYPE {SINGLE, KING}
    public  enum COLOR {RED, WHITE}

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }
}
