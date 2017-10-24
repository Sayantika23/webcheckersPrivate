package com.webcheckers.ui;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayersAvailableTest {



    @Test
    public void getUsername() throws Exception {
      final PlayersAvailable pl_test= new PlayersAvailable();
        assertEquals("",pl_test.getUsername());
    }

    @Test
    public void setUsername() throws Exception {
        final PlayersAvailable pl_test= new PlayersAvailable();
        assertEquals("",pl_test.getUsername());
        pl_test.setUsername("Fasaiel");
        assertEquals("Fasaiel",pl_test.getUsername());



    }

    @Test
    public void getPlayersAvailable() throws Exception {
    }

    /*@Test
    public void getOpponentName() throws Exception {
        final PlayersAvailable pl_test= new PlayersAvailable();
        assertEquals("",pl_test.getOpponentName());
    }*/

    @Test
    public void setOpponentName() throws Exception {
        final PlayersAvailable pl_test= new PlayersAvailable();
        //assertEquals("",pl_test.getOpponentName());
        pl_test.setOpponentName("ser");
        assertEquals("ser",pl_test.getOpponentName());
    }

    @Test
    public void addPlayer() throws Exception {
    }

}