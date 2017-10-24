package com.webcheckers.ui;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Test class for testing the class GetLoginRoute.
 *
 * @author Sankarsh Vittal
 */

public class GetLoginRouteTest {

    private Request request;
    private Response response;
    private ModelAndView modelAndView;
    private Map<String,Object> vm;

    private GetLoginRoute CuT = new GetLoginRoute();

    @Before
    public void setUp() throws Exception {

        request = Mockito.mock(Request.class);
        response = Mockito.mock(Response.class);
        modelAndView = Mockito.mock(ModelAndView.class);
        vm = Mockito.mock(HashMap.class);
    }
    @Test
    public void handle() throws Exception {

        Mockito.when(modelAndView.getViewName()).thenReturn("SignIn.ftl");

        ModelAndView result = CuT.handle(request,response);

        Map<String,Object> vm = (Map<String,Object>) result.getModel();

        assertEquals(modelAndView.getViewName(),result.getViewName());

    }
}
