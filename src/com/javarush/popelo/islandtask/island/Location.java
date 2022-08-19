package com.javarush.popelo.islandtask.island;

import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.Character;

import java.util.*;

public class Location {
    private int x;
    private int y;

    private Map<Class<? extends Character>, ArrayList<? extends Character>> characters = new HashMap<>();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getCoordinates() {
        return new int[]{this.x, this.y};
    }

    public void createCharacters() {
        Set<Class<Animal>> animals = Character.getCharacterClasses(Character.ANIMAL_PACKAGE);

        ArrayList<Animal> animalsList = new ArrayList<>();
        animals.forEach(v -> {
            Animal animal = createCharacterInstance(v);
            animal.setLocation(this);
            animalsList.add(animal);

            System.out.println(animal);
            System.out.println("*************************");
        });
        characters.put(Animal.class, animalsList);
        System.out.println("aaa");
        /*Map<Class<Plant>, Class<Plant>> plants = Character.getCharacterClasses(Character.PLANT_PACKAGE);
        ArrayList<Character> plantsList = new ArrayList<>();
        plants.forEach((k, v) -> {
            Character character = createCharacterInstance(v);
            character.setLocation(this);
            plantsList.add(character);
        });
        characters.put(Plant.class, plantsList);*/
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
            throw new RuntimeException("Exception: " + ex.getMessage());
        }
    }

}
