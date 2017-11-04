package com.webcheckers.model;

public class Message {
    private String text;
    private String type;

    public Message(String text, String type) { this.text = text;this.type = type; }

    public String getText() {
        return this.text;
    }

    public String getType() {
        return this.type;
    }

}
