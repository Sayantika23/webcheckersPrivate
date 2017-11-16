package com.webcheckers.ui;

import com.webcheckers.appl.CheckerCentre;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import spark.TemplateEngine;
public class WebServerTest {

    private TemplateEngine templateEngine = mock(TemplateEngine.class);
    private CheckerCentre checkerCenter = new CheckerCentre();
    private WebServer Cut;

    @Before
    public void setup()
    {
        Cut = new WebServer(checkerCenter,templateEngine);
    }

    @Test
    public void initializeTest()
    {
        Cut.initialize();
    }


}