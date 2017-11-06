package com.webcheckers.ui;

import static org.junit.Assert.*;

import com.webcheckers.appl.CheckerCentre;
import org.junit.Test;
import org.mockito.Mockito;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class PostSubmitTurnTest {
    private CheckerCentre checkerCentre = new CheckerCentre();


    private Request request = mock(Request.class);
    private Response response = mock(Response.class);
    PostSubmitTurn CuT;

    @Test(expected=NullPointerException.class)
    public void submitTurnTest(){
        CuT = new PostSubmitTurn(checkerCentre);
        CuT.handle(request,response);

    }

}

