package com.javarush.popelo.islandtask.animal;

import com.javarush.popelo.islandtask.interfaces.*;
import com.javarush.popelo.islandtask.island.Character;

public abstract class Animal extends Character implements Move, Eat, Eatable, Multiply, Die {

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
