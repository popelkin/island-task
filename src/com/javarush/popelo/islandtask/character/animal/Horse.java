package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.plant.Herb;

public class Horse extends Animal implements Herbivorous {

    static {
        eatProbability.put(Herb.class, 100);

        weight = 400;
        maxCountOnLocation = 20;
        speed = 4;
        saturation = 60;
    }

}
