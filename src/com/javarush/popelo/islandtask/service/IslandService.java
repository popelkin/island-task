package com.javarush.popelo.islandtask.service;

import com.javarush.popelo.islandtask.behavior.Move;
import com.javarush.popelo.islandtask.character.Character;
import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;

public class IslandService {

    public static String getStatistic(Island island) {
        int width = island.getWidth();
        int height = island.getHeight();
        Location[][] locations = island.getLocations();
        StringBuilder data = new StringBuilder();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Location location = locations[x][y];

                data.append(location.getStatistic(location));
            }
        }

        return data.toString();
    }
}
