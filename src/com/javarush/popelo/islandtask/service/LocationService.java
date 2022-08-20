package com.javarush.popelo.islandtask.service;

import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;

import static com.javarush.popelo.islandtask.service.RandomizerService.*;

public class LocationService {

    public static Location createLocation(Island island, int x, int y) {
        Location location = new Location(island, x, y);
        location.createCharacters();

        return location;
    }

    public static Location getLocationByCoordinates(Island island, int x, int y) {
        return island.getLocations()[x][y];
    }

    public static void createLocations(Island island) {
        int width = island.getWidth();
        int height = island.getHeight();
        Location[][] locations = island.getLocations();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations[x][y] = createLocation(island, x, y);
            }
        }
    }



}
