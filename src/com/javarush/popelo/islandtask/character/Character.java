package com.javarush.popelo.islandtask.character;

import com.javarush.popelo.islandtask.behavior.Die;
import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;
import com.javarush.popelo.islandtask.service.CharacterService;
import com.javarush.popelo.islandtask.service.ClassService;
import com.javarush.popelo.islandtask.service.ServiceContainer;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Character implements Die {
    public static final String ANIMAL_PACKAGE = "com.javarush.popelo.islandtask.character.animal";
    public static final String PLANT_PACKAGE = "com.javarush.popelo.islandtask.character.plant";

    protected double weight;
    protected int maxCountOnLocation;
    protected int speed;
    protected double maxSaturation;
    protected double saturation = 0;
    private Location location;

    /**
     * @return Map
     */
    public static <T extends Character> Map<String, Class<T>> getCharacterClasses(String pack) {
        ClassService classService = ServiceContainer.get("ClassService");

        return classService.getImplementedClasses(pack).stream()
                .map(e -> (Class<T>) e)
                .collect(Collectors.toMap(Class::getSimpleName, e -> e));
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

    public double getMaxSaturation() {
        return maxSaturation;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getType() {
        return this.getClass().getSuperclass().getSimpleName();
    }

    public double getSaturation() {
        return saturation;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    public void performDie() {
        CharacterService characterService = ServiceContainer.get("CharacterService");

        characterService.dieCharacter(this);
    }

}
