package com.javarush.popelo.islandtask.service;

import com.javarush.popelo.islandtask.behavior.Eat;
import com.javarush.popelo.islandtask.behavior.Move;
import com.javarush.popelo.islandtask.behavior.Multiply;
import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.Character;
import com.javarush.popelo.islandtask.exception.BaseException;
import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;

import java.util.*;

public class CharacterServiceImpl implements CharacterService {
    public void performCharactersMove(Island island) {
        int width = island.getWidth();
        int height = island.getHeight();
        Location[][] locations = island.getLocations();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Location location = locations[x][y];

                location.getCharacters().forEach((k, v) -> v.forEach((k2, v2) -> {
                    for (int i = 0; i < v.size(); i++) {
                        try {
                            Character character = (Character) v2.get(i);

                            if (character instanceof Move) {
                                ((Move) character).performMove();
                            }

                        } catch (Exception ex) {
                        }
                    }
                }));
            }
        }
    }

    public void performCharactersEat(Island island) {
        int width = island.getWidth();
        int height = island.getHeight();
        Location[][] locations = island.getLocations();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Location location = locations[x][y];

                location.getCharacters().forEach((k, v) -> v.forEach((k2, v2) -> {
                    for (int i = 0; i < v.size(); i++) {
                        try {
                            Character character = (Character) v2.get(i);

                            if (character instanceof Eat) {
                                ((Eat) character).performEat();
                            }

                        } catch (Exception ex) {
                            /*System.out.println(ex.getMessage());*/
                        }
                    }
                }));
            }
        }
    }

    public void performCharactersMultiply(Island island) {
        int width = island.getWidth();
        int height = island.getHeight();
        Location[][] locations = island.getLocations();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Location location = locations[x][y];

                location.getCharacters().forEach((k, v) -> v.forEach((k2, v2) -> {
                    for (int i = 0; i < v.size(); i++) {
                        try {
                            Character character = (Character) v2.get(i);

                            if (character instanceof Multiply) {
                                ((Multiply) character).performMultiply();
                            }

                        } catch (Exception ex) {
                        }
                    }
                }));
            }
        }
    }

    public Location getNewRandomLocation(Character character) {
        Island island = character.getIsland();
        Location location = character.getLocation();
        LocationService locationService = ServiceContainer.get("LocationService");
        RandomizerService randomizerService = ServiceContainer.get("RandomizerService");

        int width = island.getWidth();
        int height = island.getHeight();
        int newMinX = location.getCoordinateX() - 1;
        int newMaxX = location.getCoordinateX() + 1;
        int newMinY = location.getCoordinateY() - 1;
        int newMaxY = location.getCoordinateY() + 1;

        newMinX = Math.max(newMinX, 0);
        newMaxX = Math.min(newMaxX, width - 1);
        newMinY = Math.max(newMinY, 0);
        newMaxY = Math.min(newMaxY, height - 1);

        int x = randomizerService.getRandom(newMinX, newMaxX);
        int y = randomizerService.getRandom(newMinY, newMaxY);

        return locationService.getLocationByCoordinates(island, x, y);
    }

    public void validateMoveToLocation(Character character, Location destination) {
        Location location = character.getLocation();

        if (location == destination) {
            throw new BaseException("Location is the same");
        }

        int maxCountOnLocation = character.getMaxCountOnLocation();
        int count = getCharacterCountOnLocation(character, destination);

        if (count >= maxCountOnLocation) {
            throw new BaseException("Only " + maxCountOnLocation + " of " + character.getName()
                    + " max allowed on location");
        }
    }

    public int getCharacterCountOnLocation(Character character, Location location) {
        List<Character> list = getCharacterList(character, location);

        return list.size();
    }

    public List<Character> getCharacterList(Character character, Location location) {
        String type = character.getType();
        String className = character.getName();

        return location.getCharacters().get(type).get(className);
    }

    public boolean changeCharacterLocation(Character character, Location location) {
        LocationService locationService = ServiceContainer.get("LocationService");
        Location oldLocation = character.getLocation();

        try {
            validateMoveToLocation(character, location);

            removeCharacterFromLocation(character);
            locationService.updateLocationCharacterStatistic(oldLocation, character, Location.LABEL_LEFT, 1);

            addCharacterToLocation(character, location);
            locationService.updateLocationCharacterStatistic(location, character, Location.LABEL_ARRIVED, 1);

            return true;

        } catch (BaseException ex) {
            /*System.out.println(character.getName() + " couldn't move between locations: " + Arrays.toString(character.getLocation().getCoordinates())
                    + " -> " + Arrays.toString(location.getCoordinates()) +  ", reason: " + ex.getMessage());*/
        }

        return false;
    }

    public boolean eatCharacter(Character character, Character victim) {
        LocationService locationService = ServiceContainer.get("LocationService");
        Location location = character.getLocation();

        try {
            dieCharacter(victim);

            updateCharacterSaturation(character, victim.getWeight());

            locationService.updateLocationCharacterStatistic(location, character, Location.LABEL_EAT, 1);

            return true;

        } catch (BaseException ex) {
            System.out.println(character.getName() + " couldn't eat character on location: " + Arrays.toString(character.getLocation().getCoordinates())
                    + ", reason: " + ex.getMessage());
        }

        return false;
    }

    public void eatCharacterFailed(Character character) {
        updateCharacterSaturation(character, -(character.getMaxSaturation() / 5));
    }

    public void updateCharacterSaturation(Character character, double value) {
        double saturation = character.getSaturation();
        double newSaturation = saturation + value;

        if (newSaturation <= 0) {
            dieCharacter(character);

        } else {
            if (newSaturation > character.getMaxSaturation()) {
                newSaturation = character.getMaxSaturation();
            }

            character.setSaturation(newSaturation);
        }
    }

    public boolean dieCharacter(Character character) {
        LocationService locationService = ServiceContainer.get("LocationService");
        Location location = character.getLocation();

        try {
            removeCharacterFromLocation(character);

            locationService.updateLocationCharacterStatistic(location, character, Location.LABEL_DIE, 1);

            return true;

        } catch (BaseException ex) {
            System.out.println(character.getName() + " couldn't die character on location: " + Arrays.toString(character.getLocation().getCoordinates())
                    + ", reason: " + ex.getMessage());
        }

        return false;
    }

    public Character getRandomVictim(Animal animal) {
        RandomizerService randomizerService = ServiceContainer.get("RandomizerService");
        Location location = animal.getLocation();
        List<? extends Character> allVictimList = new ArrayList<>();

        if (animal.isCarnivorous()) {
            Map<String, ArrayList> victimList = getValidVictimListOnLocation(animal);

            victimList.forEach((name, list) -> allVictimList.addAll(list));
        }

        if (animal.isHerbivorous()) {
            location.getCharacters().get("Plant").forEach((name, list) -> allVictimList.addAll(list));
        }

        int random = randomizerService.getRandom(allVictimList.size());

        return allVictimList.get(random);
    }

    public Map<String, ArrayList> getValidVictimListOnLocation(Animal animal) {
        Location location = animal.getLocation();
        Map<String, Map<String, ArrayList>> characters = location.getCharacters();
        Map<String, ArrayList> animals = characters.get("Animal");
        Map<String, Integer> victimList = animal.getEatProbability();
        Set<String> animalNames = victimList.keySet();
        Map<String, ArrayList> result = new HashMap<>();

        animals.forEach((name, list) -> {
            if (animalNames.contains(name)) {
                result.put(name, list);
            }
        });

        return result;
    }

    public void removeCharacterFromLocation(Character character) {
        Location location = character.getLocation();
        List<Character> list = getCharacterList(character, location);

        list.remove(character);
        character.setLocation(null);
    }

    public void addCharacterToLocation(Character character, Location location) {
        List<Character> list = getCharacterList(character, location);

        list.add(character);
        character.setLocation(location);
    }

    /**
     * @param clazz
     * @return
     * @param <T>
     */
    public <T> T createCharacterInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();

        } catch (Exception ex) {
            throw new BaseException("Exception: " + ex.getMessage());
        }
    }

    public boolean multiplyCharacter(Character character) {
        LocationService locationService = ServiceContainer.get("LocationService");
        Location location = character.getLocation();

        try {
            removeCharacterFromLocation(character);

            locationService.updateLocationCharacterStatistic(location, character, Location.LABEL_MULTIPLY, 1);

            return true;

        } catch (BaseException ex) {
            System.out.println(character.getName() + " couldn't die character on location: " + Arrays.toString(character.getLocation().getCoordinates())
                    + ", reason: " + ex.getMessage());
        }

        return false;
    }

}
