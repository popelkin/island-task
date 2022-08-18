package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Boa extends Animal implements Carnivorous {

    static {
        eatProbability.put(Fox.class, 15);
        eatProbability.put(Rabbit.class, 20);
        eatProbability.put(Mouse.class, 40);
        eatProbability.put(Duck.class, 10);

        weight = 15;
        maxCountOnLocation = 30;
        speed = 1;
        saturation = 3;
    }

}
