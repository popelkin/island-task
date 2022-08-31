package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Goat extends Animal implements Herbivorous {

    public Goat() {
        eatProbability.put("Herb", 100);

        weight = 60;
        maxCountOnLocation = 140;
        speed = 3;
        maxSaturation = 10;
    }

}
