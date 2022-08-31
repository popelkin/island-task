package com.javarush.popelo.islandtask;

import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.service.*;

public class Main {

    public static void main(String[] args) {
        ServiceContainer.set(
            new CharacterServiceImpl(),
            new ClassServiceImpl(),
            new IslandServiceImpl(),
            new LocationServiceImpl(),
            new RandomizerServiceImpl()
        );

        IslandService islandService = ServiceContainer.get("IslandService");
        LocationService locationService = ServiceContainer.get("LocationService");
        CharacterService characterService = ServiceContainer.get("CharacterService");

        Island island = new Island(10, 10);
        locationService.createLocations(island);

        characterService.performCharactersEat(island);
        characterService.performCharactersMove(island);
        characterService.performCharactersMultiply(island);

        islandService.printStatistic(island);
    }
}
