package com.javarush.popelo.islandtask.character;

import com.javarush.popelo.islandtask.behavior.*;
import com.javarush.popelo.islandtask.exception.BaseException;
import com.javarush.popelo.islandtask.island.Location;
import com.javarush.popelo.islandtask.service.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Animal extends Character implements Move, Eat, Multiply, Die {

    protected Map<String, Integer> eatProbability = new HashMap<>();

    public boolean isHerbivorous() {
        return this instanceof Herbivorous;
    }

    public boolean isCarnivorous() {
        return this instanceof Carnivorous;
    }

    @Override
    public void performDie() {
        System.out.println("Died");
    }

    public Map<String, Integer> getEatProbability() {
        return eatProbability;
    }

    @Override
    public void performEat() {
        CharacterService characterService = ServiceContainer.get("CharacterService");
        RandomizerService randomizerService = ServiceContainer.get("RandomizerService");
        int huntTries = randomizerService.getRandom(1, 3);

        while (this.saturation < this.maxSaturation && huntTries-- > 0) {
            Character character = characterService.getRandomVictim(this);

            int percent = this.getEatProbability().get(character.getName());
            int random = randomizerService.getRandom(100);

            if (random > percent) {
                continue;
            }

            this.eat(character);
        }
    }

    private void eat(Character character) {
        System.out.println(character);
    }

    @Override
    public void performMove() {
        CharacterService characterService = ServiceContainer.get("CharacterService");
        RandomizerService randomizerService = ServiceContainer.get("RandomizerService");
        int maxSpeed = this.getSpeed();
        int speed = randomizerService.getRandom(maxSpeed);
        int[] oldCoordinates = this.getLocation().getCoordinates();
        Location newLocation = this.getLocation();

        for (int i = 1; i <= speed; i++) {
            newLocation = characterService.getNewRandomLocation(this);

            this.move(newLocation);
        }

        int[] newCoordinates = newLocation.getCoordinates();

        if (!Arrays.equals(oldCoordinates, newCoordinates)) {
            System.out.println(this.getName() + " changed location from " + Arrays.toString(oldCoordinates) + " -> "
                    + Arrays.toString(newCoordinates));

        } else {
            System.out.println(this.getName() + " left on the same location");
        }
    }

    @Override
    public void performMultiply() {
        System.out.println("Multiply");
    }

    private boolean move(Location destination) {
        CharacterService characterService = ServiceContainer.get("CharacterService");

        return characterService.changeCharacterLocation(this, destination);
    }


}
