package com.javarush.popelo.islandtask.island;

import com.javarush.popelo.islandtask.service.CharacterService;
import com.javarush.popelo.islandtask.service.LocationService;

public class Island {
    private final int width;
    private final int height;

    private Location[][] locations;

    /**
     * @param width
     * @param height
     */
    public Island(int width, int height) {
        this.width = width;
        this.height = height;

        locations = new Location[width][height];
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void createLocations() {
        LocationService.createLocations(this);
    }

    public void performCharactersMove() {
        CharacterService.performCharactersMove(this);
    }

}
