package com.javarush.popelo.islandtask.character;

import com.javarush.popelo.islandtask.behavior.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Animal extends Character implements Move, Eat, Eatable, Multiply, Die {

    protected static Map<Class, Integer> eatProbability = new HashMap<>();

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
        System.out.println("Move");
    }

    @Override
    public void performMultiply() {
        System.out.println("Multiply");
    }
}
