package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Row implements Iterable<Space>{
    private List<Space> spaces;
    private int index;

    public Row(int pos) {
        spaces = new ArrayList<>();
        this.index = pos;

        for(int i=0; i<=7; i++) {
            if((pos == 0 || pos == 2) && i % 2 == 1) {
                spaces.add(new Space("black", new Piece("SINGLE", "WHITE"), i));
            } else if(pos == 1 && i % 2 == 0) {
                spaces.add(new Space("black", new Piece("SINGLE", "WHITE"), i));
            } else if((pos == 3 && i % 2 == 0) || (pos == 4 && i % 2 == 1)) {
                spaces.add(new Space("black", null, i));
            } else if((pos == 5 || pos == 7) && i % 2 == 0) {
                spaces.add(new Space("black", new Piece("SINGLE", "RED"), i));
            } else if(pos == 6 && i % 2 == 1) {
                spaces.add(new Space("black", new Piece("SINGLE", "RED"), i));
            } else {
                spaces.add(new Space("white", null, i));
            }
        }
    }



    public Iterator<Space> iterator() {
        return spaces.iterator();
    }


    public void forEach(Consumer<? super Space> action) {

    }


    public Spliterator<Space> spliterator() {
        return null;
    }

    public int getIndex() {
        return this.index;
    }


    public List<Space> getSpaces() {
        return this.spaces;
    }





}


