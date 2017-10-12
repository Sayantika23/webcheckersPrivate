package com.webcheckers.model;

import java.util.ArrayList;


/**
 *
 * Shows the current players available for the game of WebCheckers
 * @author Sankarsh,Hiten,Girish,Fasaiel
 */

public class CurrentPlayers {
    public static ArrayList<CurrentPlayers> currentPlayers = new ArrayList<>();
    private String name;
    private boolean isAvailabale;

    public CurrentPlayers(String name) {
        this.name = name;
        this.isAvailabale = true;
    }

    public String getName()
    {
        return name;
    }

    public CurrentPlayers(String name, boolean isAvailabale)
    {
        this.name = name;
        this.isAvailabale = isAvailabale;

    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isAvailabale()
    {
        return isAvailabale;
    }

    public void setAvailable(boolean available)
    {
        isAvailabale= available;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        CurrentPlayers that = (CurrentPlayers) object;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public String toString()
    {
        return this.getName();
    }
}
