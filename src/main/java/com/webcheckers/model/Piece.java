package com.webcheckers.model;


/**
 *
 *  Shows the type of piece on the borad for the CheckersGame
 * @author Sankarsh,Hiten,Girish,Fasaiel
 */
public class Piece {

    public TEnum type;
    public CEnum color;

    public enum TEnum{SINGLE, KING}
    public  enum CEnum {RED, WHITE}

    public TEnum getType() {
        return type;
    }

    public void setType(TEnum type) {
        this.type = type;
    }

    public CEnum getColor() {
        return color;
    }

    public void setColor(CEnum color) {
        this.color = color;
    }
}
