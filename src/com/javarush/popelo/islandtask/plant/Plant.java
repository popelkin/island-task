package com.javarush.popelo.islandtask.plant;

import com.javarush.popelo.islandtask.interfaces.Eatable;
import com.javarush.popelo.islandtask.interfaces.Multiply;
import com.javarush.popelo.islandtask.island.Character;

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
