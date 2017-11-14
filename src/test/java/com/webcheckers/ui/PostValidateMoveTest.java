package com.webcheckers.ui;

import com.webcheckers.appl.CheckerCentre;
import com.webcheckers.model.ManageGame;
import com.webcheckers.model.Message;
import com.webcheckers.model.Player;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostValidateMoveTest {
    private String Playername="playername";
    private String Playerone="player1";
    private String Playertwo="player2";
    private Player PLAYER1= new Player(Playerone);
    private Player PLAYER2= new Player(Playertwo);
    private ManageGame game = new ManageGame(PLAYER1,PLAYER2);

    private Session s1= mock (Session.class);
    private Session s2= mock (Session.class);
    private Request r1;
    private Request r2;
    private Response r;

   private CheckerCentre checkerCentre= new CheckerCentre();
    private PostValidateMove CuT;


    @Before
    public void setup()
    {
        ManageGame game = new ManageGame(PLAYER1,PLAYER2);

        r1 = mock(Request.class);
        r2 = mock(Request.class);
        when(r1.body()).thenReturn("{\"start\":{\"row\":\"5\",\"cell\":\"0\"},\"end\":{\"row\":\"4\",\"cell\":\"1\"}}");
        when(r2.body()).thenReturn("{\"start\":{\"row\":\"2\",\"cell\":\"1\"},\"end\":{\"row\":\"0\",\"cell\":\"0\"}}");
        when(r1.session()).thenReturn(s1);
        when(r2.session()).thenReturn(s2);
        when(s1.attribute(Playername)).thenReturn(Playerone);
        when(s2.attribute(Playername)).thenReturn(Playertwo);
        r = mock(Response.class);

    }

    @Test(expected=NullPointerException.class)
    public void test_handle()
    {
        assertEquals(Message.class, CuT.handle(r1, r).getClass());
        assertEquals(Message.class, CuT.handle(r2, r).getClass());

    }

}

