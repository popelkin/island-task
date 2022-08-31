package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Sheep extends Animal implements Herbivorous {

    public Sheep() {
        eatProbability.put("Herb", 100);

        weight = 70;
        maxCountOnLocation = 140;
        speed = 3;
        maxSaturation = 15;
    }

}
