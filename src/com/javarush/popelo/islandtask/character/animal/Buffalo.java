package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.plant.Herb;

public class Buffalo extends Animal implements Herbivorous {

     {
        eatProbability.put(Herb.class, 100);

        weight = 700;
        maxCountOnLocation = 10;
        speed = 3;
        saturation = 100;
    }

}
