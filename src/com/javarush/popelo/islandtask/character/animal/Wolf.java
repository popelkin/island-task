package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Wolf extends Animal implements Carnivorous {

    static {
        eatProbability.put(Horse.class, 10);
        eatProbability.put(Deer.class, 15);
        eatProbability.put(Rabbit.class, 60);
        eatProbability.put(Mouse.class, 80);
        eatProbability.put(Goat.class, 60);
        eatProbability.put(Sheep.class, 70);
        eatProbability.put(Boar.class, 15);
        eatProbability.put(Buffalo.class, 10);
        eatProbability.put(Duck.class, 40);

        weight = 50;
        maxCountOnLocation = 30;
        speed = 3;
        saturation = 8;
    }

}
