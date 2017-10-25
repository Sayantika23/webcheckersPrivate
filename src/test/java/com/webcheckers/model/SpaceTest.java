package com.webcheckers.model;

import org.hibernate.validator.constraints.SafeHtml;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static java.lang.Boolean.TRUE;
import static org.eclipse.jetty.webapp.MetaDataComplete.True;
import static org.junit.Assert.*;

public class SpaceTest {

    private int cellIdx;
    private boolean isValid;
    private Piece piece;
    private int Index;
    private Space space;

   @Before
   public void setUp() throws Exception{

       space = new Space(1,TRUE);
    }




    @Test
    public void checkCellIdx(){



        Space space = new Space(1,true);
        assertEquals(1, space.getCellIdx());
    }


}