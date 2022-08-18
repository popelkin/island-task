package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.plant.Herb;

public class Boar extends Animal implements Herbivorous, Carnivorous {

    static {
        eatProbability.put(Mouse.class, 50);
        eatProbability.put(Caterpillar.class, 90);
        eatProbability.put(Herb.class, 100);

        weight = 400;
        maxCountOnLocation = 50;
        speed = 2;
        saturation = 50;
    }

}
