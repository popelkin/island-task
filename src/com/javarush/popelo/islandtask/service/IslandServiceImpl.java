package com.javarush.popelo.islandtask.service;

import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;

public class IslandServiceImpl implements IslandService {
    public void printStatistic(Island island) {
        int width = island.getWidth();
        int height = island.getHeight();
        Location[][] locations = island.getLocations();
        StringBuilder data = new StringBuilder();
        LocationService locationService = ServiceContainer.get("LocationService");

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Location location = locations[x][y];

                data.append(locationService.getLocationStatistic(location));
            }
        }

        System.out.println(data);
    }
}
