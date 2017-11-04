package com.webcheckers.model;

public class Piece {
    private String type;
    private String color;


    public Piece(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }


    public String getType() {
        return this.type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }
}
