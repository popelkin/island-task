package com.javarush.popelo.islandtask.island;

public class Island {
    private final int width;
    private final int height;

    private final Location[][] locations;

    /**
     * @param width
     * @param height
     */
    public Island(int width, int height) {
        this.width = width;
        this.height = height;

        locations = new Location[width][height];
    }

    /**
     *
     */
    public void createLocations() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Location location = new Location(x, y);

                location.createCharacters();

                locations[x][y] = location;
            }
        }
    }

}
