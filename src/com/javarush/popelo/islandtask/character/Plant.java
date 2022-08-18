package com.javarush.popelo.islandtask.character;

import com.javarush.popelo.islandtask.behavior.Eatable;
import com.javarush.popelo.islandtask.behavior.Multiply;
import com.javarush.popelo.islandtask.character.Character;

public abstract class Plant extends Character implements Eatable, Multiply {

    @Override
    public void performEatable() {
        System.out.println("Eatable");
    }

    @Override
    public void performMultiply() {
        System.out.println("Multiply");
    }
}
