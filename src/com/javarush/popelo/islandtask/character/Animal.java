package com.javarush.popelo.islandtask.character;

import com.javarush.popelo.islandtask.behavior.*;
import com.javarush.popelo.islandtask.exception.BaseException;
import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;
import com.javarush.popelo.islandtask.service.CharacterService;
import com.javarush.popelo.islandtask.service.LocationService;
import com.javarush.popelo.islandtask.service.RandomizerService;

import java.util.HashMap;
import java.util.Map;

public abstract class Animal extends Character implements Move, Eat, Eatable, Multiply, Die {

    protected Map<Class<? extends Character>, Integer> eatProbability = new HashMap<>();

    /**
     * @return boolean
     */
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

    @Override
    public void performEat() {
        System.out.println("Eat");
    }

    @Override
    public void performEatable() {
        System.out.println("Eatable");
    }

    @Override
    public void performMove() {
        int maxSpeed = this.getSpeed();
        int speed = RandomizerService.getRandomInt(maxSpeed);

        for (int i = 1; i <= speed; i++) {
            Location newLocation = CharacterService.getNewRandomLocation(this);

            try {
                this.move(newLocation);

            } catch (BaseException ex) {
                System.out.println("Can't move to destination location, reason: " + ex.getMessage());
            }
        }
        /*
        1. move times
        2. new coordinates
        3. move
        4. population count
         */
    }

    @Override
    public void performMultiply() {
        System.out.println("Multiply");
    }

    public boolean move(Location destination) {
        return CharacterService.changeCharacterLocation(this, destination);
    }


}
