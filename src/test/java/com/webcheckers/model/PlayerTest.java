package com.webcheckers.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {



    @Test
    public void testGetUsername() throws Exception {
        String username = "Smith";
        Player test = new Player(username);
        assertEquals("Smith", test.getUsername());
    }


    @Test
    public void testEquals() throws Exception {
        String firstUser = "Smith";
        String secondUser = "Smith";
        Player player = new Player(firstUser);
        Player player2 = new Player(secondUser);
        assertTrue(player.equals(player2));


    }
}

