package com.javarush.popelo.islandtask.island;

import com.javarush.popelo.islandtask.character.Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Location {

    private Map<String, ArrayList<Character>> characters = new HashMap<>();

    public Location() {

    }

    public void fillWithCharacters() {
        Map<String, Class> animals = Character.getAnimals();
        ArrayList<Character> animalsList = new ArrayList<>();
        animals.forEach((k, v) -> animalsList.add(createCharacter(v)));
        characters.put("Animals", animalsList);

        Map<String, Class> plants = Character.getPlants();
        ArrayList<Character> plantsList = new ArrayList<>();
        plants.forEach((k, v) -> plantsList.add(createCharacter(v)));
        characters.put("Plants", plantsList);
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
