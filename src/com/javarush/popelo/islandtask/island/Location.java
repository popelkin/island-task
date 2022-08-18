package com.javarush.popelo.islandtask.island;

import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.Character;
import com.javarush.popelo.islandtask.character.Plant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Location {
    private int x;
    private int y;

    private Map<Class, ArrayList<Character>> characters = new HashMap<>();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getCoordinates() {
        return new int[]{this.x, this.y};
    }

    public void createCharacters() {
        Map<Class<Animal>, Class<Animal>> animals = Character.getCharacters(Character.ANIMAL_PACKAGE);
        ArrayList<Character> animalsList = new ArrayList<>();
        animals.forEach((k, v) -> {
            Character character = createCharacter(v);
            character.setLocation(this);
            animalsList.add(character);
        });
        characters.put(Animal.class, animalsList);

        Map<Class<Plant>, Class<Plant>> plants = Character.getCharacters(Character.PLANT_PACKAGE);
        ArrayList<Character> plantsList = new ArrayList<>();
        plants.forEach((k, v) -> {
            Character character = createCharacter(v);
            character.setLocation(this);
            plantsList.add(character);
        });
        characters.put(Plant.class, plantsList);
    }

    /**
     * @param clazz
     * @return
     */
    private Character createCharacter(Class clazz) {
        try {
            return (Character) clazz.getDeclaredConstructor().newInstance();

        } catch (Exception ex) {
            throw new RuntimeException("Exception: " + ex.getMessage());
        }
    }

}
