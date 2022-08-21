package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Horse extends Animal implements Herbivorous {

    public Horse() {
        eatProbability.put("Herb", 100);

        weight = 400;
        maxCountOnLocation = 20;
        speed = 4;
        saturation = 60;
    }

}
