package com.javarush.popelo.islandtask.service;

import com.javarush.popelo.islandtask.character.Character;
import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;
import java.util.Map;

public interface LocationService extends Service {

    Location createLocation(Island island, int x, int y);

    Location getLocationByCoordinates(Island island, int x, int y);

    void createLocations(Island island);

    String getLocationStatistic(Location location);

    void updateLocationCharacterStatistic(Location location, Character character, String field, int value);

    void setLocationCharacterStatistic(Location location, Character character, String field, int value);

    Map<String, Integer> getLocationCharacterStatistic(Location location, Character character);

    void recountFinalQuantityLocationCharacter(Location location, Character character);

}
