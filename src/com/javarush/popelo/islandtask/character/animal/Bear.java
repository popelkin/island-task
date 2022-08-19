package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Bear extends Animal implements Carnivorous {

    public Bear() {
        eatProbability.put(Boa.class, 80);
        eatProbability.put(Horse.class, 40);
        eatProbability.put(Deer.class, 80);
        eatProbability.put(Rabbit.class, 80);
        eatProbability.put(Mouse.class, 90);
        eatProbability.put(Goat.class, 70);
        eatProbability.put(Sheep.class, 70);
        eatProbability.put(Boar.class, 50);
        eatProbability.put(Buffalo.class, 20);
        eatProbability.put(Duck.class, 10);

        weight = 500;
        maxCountOnLocation = 5;
        speed = 2;
        saturation = 80;
    }

}
