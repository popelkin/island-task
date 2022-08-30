package com.javarush.popelo.islandtask.island;

import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.Character;
import com.javarush.popelo.islandtask.character.Plant;
import com.javarush.popelo.islandtask.service.*;

import java.util.*;

public class Location {
    private final int x;
    private final int y;
    private final Island island;

    private final Map<String, Map<String, ArrayList>> characters = new HashMap<>();
    private final Map<String, Map<String, Map<String, Integer>>> statistic = new HashMap<>();
    public static final String LABEL_START_COUNT = "Start quantity";
    public static final String LABEL_DIE = "Died count";
    public static final String LABEL_EAT = "Ate count";
    public static final String LABEL_LEFT = "Left count";
    public static final String LABEL_ARRIVED = "Arrived count";
    public static final String LABEL_MULTIPLY = "Multiply count";
    public static final String LABEL_FINAL_COUNT = "Final quantity";

    public Location(Island island, int x, int y) {
        this.island = island;
        this.x = x;
        this.y = y;
    }

    public int getCoordinateX() {
        return this.x;
    }

    public int getCoordinateY() {
        return this.y;
    }

    public Island getIsland() {
        return this.island;
    }

    public void createCharacters() {
        // create Animals
        Map<String, ArrayList> animalsMap = new HashMap<>();
        Map<String, Class<Animal>> animals = Character.getCharacterClasses(Character.ANIMAL_PACKAGE);
        RandomizerService randomizerService = ServiceContainer.get("RandomizerService");
        CharacterService characterService = ServiceContainer.get("CharacterService");

        animals.forEach((name, v) -> {
            Animal tmp = characterService.createCharacterInstance(v);
            int maxCount = tmp.getMaxCountOnLocation();
            int count = randomizerService.getRandom(maxCount);
            String animalClassName = tmp.getName();

            if (!animalsMap.containsKey(animalClassName)) {
                animalsMap.put(animalClassName, new ArrayList<>());
            }

            for (int i = 0; i < count; i++) {
                Animal animal = characterService.createCharacterInstance(v);
                animal.setLocation(this);

                animalsMap.get(animalClassName).add(animal);
            }
        });
        characters.put("Animal", animalsMap);
        ///

        // create Plants
        Map<String, ArrayList> plantsMap = new HashMap<>();
        Map<String, Class<Plant>> plants = Character.getCharacterClasses(Character.PLANT_PACKAGE);

        plants.forEach((name, v) -> {
            Plant tmp = characterService.createCharacterInstance(v);
            int maxCount = tmp.getMaxCountOnLocation();
            int count = randomizerService.getRandom(maxCount);
            String plantClassName = tmp.getName();

            if (!plantsMap.containsKey(plantClassName)) {
                plantsMap.put(plantClassName, new ArrayList<>());
            }

            for (int i = 0; i < count; i++) {
                Plant plant = characterService.createCharacterInstance(v);
                plant.setLocation(this);

                plantsMap.get(plantClassName).add(plant);
            }
        });
        characters.put("Plant", plantsMap);
        ///
    }

    public void initStatistic() {
        this.characters.forEach((type, list) -> {
            list.forEach((name, list2) -> {
                if (!this.statistic.containsKey(type)) {
                    this.statistic.put(type, new HashMap<>());
                }

                if (!this.statistic.get(type).containsKey(name)) {
                    this.statistic.get(type).put(name, new HashMap<>(){{
                        put(LABEL_START_COUNT, list2.size());
                        put(LABEL_DIE, 0);
                        put(LABEL_ARRIVED, 0);
                        put(LABEL_FINAL_COUNT, list2.size());

                        if (!type.equals(Plant.class.getSimpleName())) {
                            put(LABEL_EAT, 0);
                            put(LABEL_MULTIPLY, 0);
                            put(LABEL_LEFT, 0);
                        }
                    }});
                }
            });
        });
    }

    public Map<String, Map<String, Map<String, Integer>>> getStatistic() {
        return this.statistic;
    }

    public Map<String, Map<String, ArrayList>> getCharacters() {
        return characters;
    }

    public int[] getCoordinates() {
        return new int[]{this.x, this.y};
    }

    public String getStatistic(Location location) {
        LocationService locationService = ServiceContainer.get("LocationService");

        return locationService.getLocationStatistic(location);
    }

}
