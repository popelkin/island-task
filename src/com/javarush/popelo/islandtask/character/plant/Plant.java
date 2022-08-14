package com.javarush.popelo.islandtask.character.plant;

import com.javarush.popelo.islandtask.behavior.Eatable;
import com.javarush.popelo.islandtask.behavior.Multiply;
import com.javarush.popelo.islandtask.character.Character;

public class Plant extends Character implements Eatable, Multiply {

    static {
        weight = 1;
        maxCountOnLocation = 200;
    }

    @Override
    public void performEatable() {
        System.out.println("Eatable");
    }

    @Override
    public void performMultiply() {
        System.out.println("Multiply");
    }
}
