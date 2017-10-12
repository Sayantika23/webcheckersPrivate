package com.webcheckers.model;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 *  Class to indicate the row index on the checkers board
 * @author Sankarsh,Hiten,Girish,Fasaiel
 */

public class Row implements Iterable<Space> {
    public LinkedList<Space> spaces = new LinkedList<>();
    public int index;


    public Iterator<Space> iterator() { return spaces.iterator(); }
    public int getIndex(){
        return index;
    }

    public void setIndex(int index) {
        this.index=index;
    }

    public Row(int index){
        this.index=index;
    }


}

