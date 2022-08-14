package com.javarush.popelo.islandtask.island;

import java.time.LocalDate;

public class Island {
    private int width;
    private int height;

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

    /**
     *
     */
    public void fillWithLocations() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Location location = new Location();

                location.fillWithCharacters();

                locations[i][j] = location;
            }
        }
    }

}
