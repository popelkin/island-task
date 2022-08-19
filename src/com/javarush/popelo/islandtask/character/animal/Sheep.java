package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.plant.Herb;

public class Sheep extends Animal implements Herbivorous {

     {
        eatProbability.put(Herb.class, 100);

        weight = 70;
        maxCountOnLocation = 140;
        speed = 3;
        saturation = 15;
    }

}
