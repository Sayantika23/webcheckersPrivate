package com.webcheckers.ui;

import com.sun.tools.internal.xjc.model.Model;
import javafx.geometry.Pos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PostLoginRouteTest {
    private Request request;
    private Response response;
    private ModelAndView modelAndView;
    private Map<String,Object> vm;
    private Session session;


    @Before
    public void setUp() throws Exception {

        request = Mockito.mock(Request.class);
        response = Mockito.mock(Response.class);
        modelAndView = Mockito.mock(ModelAndView.class);
        vm = Mockito.mock(HashMap.class);
        session = Mockito.mock(Session.class);
    }


    /**
     * This test case is used to check when the list doesn't contain the name then it should
     * add the name of the user.
     * @throws Exception
     */
    @Test
    public void handle() throws Exception {

        //Making object of the class
        PostLoginRoute postLoginRoute = new PostLoginRoute();

        //Adding playername to the query of parameters
        Mockito.when(request.queryParams("username")).thenReturn( "hiten");

        //Mocking the view object
        Mockito.when(modelAndView.getViewName()).thenReturn("SignIn.ftl");

        //Now adding the player name so that it has one entry for the same name
        PlayersAvailable.playersAvailable.add("hiten");


        ModelAndView testModelAndView = postLoginRoute.handle(request,response);

        Map<String,Object> vmTest = (Map<String,Object>) testModelAndView.getModel();

        assertEquals(modelAndView.getViewName(),testModelAndView.getViewName());

    }

}