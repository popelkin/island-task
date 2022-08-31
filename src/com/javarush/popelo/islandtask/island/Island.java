package com.javarush.popelo.islandtask.island;

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
