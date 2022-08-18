package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.plant.Herb;

public class Deer extends Animal implements Herbivorous {

    static {
        eatProbability.put(Herb.class, 100);

        weight = 300;
        maxCountOnLocation = 20;
        speed = 4;
        saturation = 50;
    }

}
