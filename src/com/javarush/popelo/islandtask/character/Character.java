package com.javarush.popelo.islandtask.character;

import com.javarush.popelo.islandtask.island.Location;
import com.javarush.popelo.islandtask.service.ClassService;
import java.util.Map;

public abstract class Character {
    protected static double weight;
    protected static int maxCountOnLocation;
    protected static int speed;
    protected static double saturation;
    private Location location;

    public static final String ANIMAL_PACKAGE = "com.javarush.popelo.islandtask.character.animal";
    public static final String PLANT_PACKAGE = "com.javarush.popelo.islandtask.character.plant";

    /**
     * @return Map
     */
    public static <T extends Character> Map<Class<T>, Class<T>> getCharacters(String pack) {
        return ClassService.getImplementedClasses(pack);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
