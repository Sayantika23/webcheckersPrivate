package com.webcheckers.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MessageTest {

    String messageText = "Hello";
    String messageType="error";

    /**
     * Tests Creating a new Message
     */
    @Test
    public void CreateMessageTest()
    {
        Message message = new Message(messageText, messageType);
        assertNotNull(message);
        assertEquals(message.getText(),messageText);
        assertEquals(message.getType(), messageType);
    }


    @Test

    public void getTextTest()
    {
        Message message = new Message(messageText, messageType);
        assertEquals(message.getText(),messageText);
    }


    public void getTypeTest()
    {
        Message message = new Message(messageText, messageType);
        assertEquals(message.getType(),messageType);
    }



}

