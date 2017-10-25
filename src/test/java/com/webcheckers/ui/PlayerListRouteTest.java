package com.wecheckers.ui;

import static org.junit.Assert.*;

import org.mockito.Mockito;

import java.util.*;

import com.webcheckers.ui.PlayerListRoute;

import org.junit.Before;
import org.junit.Test;

import spark.*;

/** Unit Test for the PlayerListRoute Component
 *  @author Girish Kumar
 */
public class PlayerListRouteTest {

    private Request request;
    private Response response;
    private ModelAndView modelAndView;
    private Map<String,Object> vm;

    private PlayerListRoute CuT = new PlayerListRoute();

    @Before
    public void setUp() throws Exception {

        request = Mockito.mock(Request.class);
        response = Mockito.mock(Response.class);
        modelAndView = Mockito.mock(ModelAndView.class);
        vm = Mockito.mock(HashMap.class);
    }
    @Test
    public void handle() throws Exception {

        Mockito.when(modelAndView.getViewName()).thenReturn("playerlist.ftl");

        ModelAndView result = CuT.handle(request,response);

        Map<String,Object> vm = (Map<String,Object>) result.getModel();

        assertEquals(modelAndView.getViewName(),result.getViewName());

    }

    }


