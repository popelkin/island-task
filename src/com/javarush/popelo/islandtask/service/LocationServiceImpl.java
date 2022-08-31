package com.javarush.popelo.islandtask.service;

import com.javarush.popelo.islandtask.character.Character;
import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LocationServiceImpl implements LocationService {

    public Location createLocation(Island island, int x, int y) {
        Location location = new Location(island, x, y);

        location.createCharacters();
        location.initStatistic();

        return location;
    }

    public Location getLocationByCoordinates(Island island, int x, int y) {
        return island.getLocations()[x][y];
    }

    public void createLocations(Island island) {
        int width = island.getWidth();
        int height = island.getHeight();
        Location[][] locations = island.getLocations();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations[x][y] = createLocation(island, x, y);
            }
        }
    }

    public String getLocationStatistic(Location location) {
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

    public void updateLocationCharacterStatistic(Location location, Character character, String field, int value) {
        Map<String, Integer> stat = getLocationCharacterStatistic(location, character);
        int oldValue = stat.get(field);

        stat.put(field, oldValue + value);

        recountFinalQuantityLocationCharacter(location, character);
    }

    public void setLocationCharacterStatistic(Location location, Character character, String field, int value) {
        Map<String, Integer> stat = getLocationCharacterStatistic(location, character);
        stat.put(field, value);
    }

    public Map<String, Integer> getLocationCharacterStatistic(Location location, Character character) {
        String type = character.getType();
        String name = character.getName();

        return location.getStatistic().get(type).get(name);
    }

    public void recountFinalQuantityLocationCharacter(Location location, Character character) {
        CharacterService characterService = ServiceContainer.get("CharacterService");
        List<Character> list = characterService.getCharacterList(character, location);

        setLocationCharacterStatistic(location, character, Location.LABEL_FINAL_COUNT, list.size());
    }


}
