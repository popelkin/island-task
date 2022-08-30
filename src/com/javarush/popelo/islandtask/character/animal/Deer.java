package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Deer extends Animal implements Herbivorous {

    public Deer() {
        eatProbability.put("Herb", 100);

        weight = 300;
        maxCountOnLocation = 20;
        speed = 4;
        maxSaturation = 50;
    }

}
