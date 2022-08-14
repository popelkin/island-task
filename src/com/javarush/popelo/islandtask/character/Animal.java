package com.javarush.popelo.islandtask.character;

import com.javarush.popelo.islandtask.behavior.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Animal extends Character implements Move, Eat, Eatable, Multiply, Die {

    protected static Map<String, Integer> eatProbability = new HashMap<>();

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
