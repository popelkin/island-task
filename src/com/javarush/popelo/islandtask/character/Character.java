package com.javarush.popelo.islandtask.character;

import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;
import com.javarush.popelo.islandtask.service.ClassService;
import com.javarush.popelo.islandtask.service.ClassServiceImpl;
import com.javarush.popelo.islandtask.service.RandomizerService;
import com.javarush.popelo.islandtask.service.ServiceContainer;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class Character {
    protected double weight;
    protected int maxCountOnLocation;
    protected int speed;
    protected double saturation;
    private Location location;

    public static final String ANIMAL_PACKAGE = "com.javarush.popelo.islandtask.character.animal";
    public static final String PLANT_PACKAGE = "com.javarush.popelo.islandtask.character.plant";

    /**
     * @return Map
     */
    public static <T extends Character> Set<Class<T>> getCharacterClasses(String pack) {
        ClassService classService = ServiceContainer.get("ClassService");

        return classService.getImplementedClasses(pack).stream()
                .map(e -> (Class<T>) e)
                .collect(Collectors.toSet());
    }

    public Location getLocation() {
        return location;
    }

    public Island getIsland() {
        return this.getLocation().getIsland();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountOnLocation() {
        return maxCountOnLocation;
    }

    public int getSpeed() {
        return speed;
    }

    public double getSaturation() {
        return saturation;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getType() {
        return this.getClass().getSuperclass().getSimpleName();
    }

    @Override
    public String toString() {
        return "Character{" +
                "weight=" + weight +
                ", maxCountOnLocation=" + maxCountOnLocation +
                ", speed=" + speed +
                ", saturation=" + saturation +
                ", location=" + location +
                '}';
    }

}
