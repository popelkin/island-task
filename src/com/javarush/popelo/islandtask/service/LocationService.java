package com.javarush.popelo.islandtask.service;

import com.javarush.popelo.islandtask.character.Character;
import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;

import java.util.Arrays;
import java.util.Map;

public class LocationService {

    public static Location createLocation(Island island, int x, int y) {
        Location location = new Location(island, x, y);
        location.createCharacters();
        location.initStatistic();

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

    public static String getLocationStatistic(Location location) {
        StringBuilder data = new StringBuilder();

        data.append("Location " + Arrays.toString(location.getCoordinates()) + "\n");

        location.getStatistic().forEach((type, list) -> {
            data.append(type + "\n");

            list.forEach((name, statistic) -> {
                data.append("   " + name + ":\n");

                statistic.forEach((line, value) -> data.append("       " + line + ": " + value + "\n"));
            });
        });

        return data.toString();
    }

    public static void updateLocationCharacterStatistic(Location location, Character character, String field, int value) {
        Map<String, Integer> stat = getLocationCharacterStatistic(location, character);
        int oldValue = stat.get(field);

        stat.put(field, oldValue + value);

        recountFinalQuantityLocationCharacter(location, character);
    }

    public static void setLocationCharacterStatistic(Location location, Character character, String field, int value) {
        Map<String, Integer> stat = getLocationCharacterStatistic(location, character);
        stat.put(field, value);
    }

    public static Map<String, Integer> getLocationCharacterStatistic(Location location, Character character) {
        String type = character.getType();
        String name = character.getName();

        return location.getStatistic().get(type).get(name);
    }

    private static void recountFinalQuantityLocationCharacter(Location location, Character character) {
        String type = character.getType();
        String name = character.getName();
        int quantity = location.getCharacters().get(type).get(name).size();

        setLocationCharacterStatistic(location, character, Location.STATISTIC_FINAL_COUNT, quantity);
    }


}
