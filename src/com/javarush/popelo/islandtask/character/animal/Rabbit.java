package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.plant.Herb;

public class Rabbit extends Animal implements Herbivorous {

     {
        eatProbability.put(Herb.class, 100);

        weight = 2;
        maxCountOnLocation = 150;
        speed = 2;
        saturation = 0.45;
    }

}
