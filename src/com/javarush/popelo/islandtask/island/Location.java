package com.javarush.popelo.islandtask.island;

import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.Character;
import com.javarush.popelo.islandtask.character.Plant;
import com.javarush.popelo.islandtask.exception.BaseException;
import com.javarush.popelo.islandtask.service.LocationService;
import com.javarush.popelo.islandtask.service.RandomizerService;

import java.util.*;

public class Location {
    private int x;
    private int y;
    private Island island;

    private final Map<String, Map<String, ArrayList>> characters = new HashMap<>();
    private final Map<String, Map<String, Map<String, Integer>>> statistic = new HashMap<>();

    public static final String STATISTIC_START_COUNT = "Start quantity";
    public static final String STATISTIC_DIE = "Died count";
    public static final String STATISTIC_EAT = "Ate count";
    public static final String STATISTIC_LEFT = "Left count";
    public static final String STATISTIC_ARRIVED = "Arrived count";
    public static final String STATISTIC_MULTIPLY = "Multiply count";
    public static final String STATISTIC_FINAL_COUNT = "Final quantity";

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
        Set<Class<Animal>> animals = Character.getCharacterClasses(Character.ANIMAL_PACKAGE);

        animals.forEach(v -> {
            Animal tmp = createCharacterInstance(v);
            int maxCount = tmp.getMaxCountOnLocation();
            int count = RandomizerService.getRandomInt(maxCount);
            String animalClassName = tmp.getName();

            if (!animalsMap.containsKey(animalClassName)) {
                animalsMap.put(animalClassName, new ArrayList<>());
            }

            for (int i = 0; i < count; i++) {
                Animal animal = createCharacterInstance(v);
                animal.setLocation(this);

                animalsMap.get(animalClassName).add(animal);
            }
        });
        characters.put("Animal", animalsMap);
        ///

        // create Plants
        Map<String, ArrayList> plantsMap = new HashMap<>();
        Set<Class<Plant>> plants = Character.getCharacterClasses(Character.PLANT_PACKAGE);

        plants.forEach(v -> {
            Plant tmp = createCharacterInstance(v);
            int maxCount = tmp.getMaxCountOnLocation();
            int count = RandomizerService.getRandomInt(maxCount);
            String plantClassName = tmp.getName();

            if (!plantsMap.containsKey(plantClassName)) {
                plantsMap.put(plantClassName, new ArrayList<>());
            }

            for (int i = 0; i < count; i++) {
                Plant plant = createCharacterInstance(v);
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
                        put(STATISTIC_START_COUNT, list2.size());
                        put(STATISTIC_DIE, 0);
                        put(STATISTIC_ARRIVED, 0);
                        put(STATISTIC_FINAL_COUNT, list2.size());

                        if (!type.equals(Plant.class.getSimpleName())) {
                            put(STATISTIC_EAT, 0);
                            put(STATISTIC_MULTIPLY, 0);
                            put(STATISTIC_LEFT, 0);
                        }
                    }});
                }
            });
        });
    }

    public Map<String, Map<String, Map<String, Integer>>> getStatistic() {
        return this.statistic;
    }

    /**
     * @param clazz
     * @return
     * @param <T>
     */
    private <T> T createCharacterInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();

        } catch (Exception ex) {
            throw new BaseException("Exception: " + ex.getMessage());
        }
    }

    public Map<String, Map<String, ArrayList>> getCharacters() {
        return characters;
    }

    public int[] getCoordinates() {
        return new int[]{this.x, this.y};
    }

    public String getStatistic(Location location) {
        return LocationService.getLocationStatistic(location);
    }

}
