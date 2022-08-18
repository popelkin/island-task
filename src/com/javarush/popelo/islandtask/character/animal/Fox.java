package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Fox extends Animal implements Carnivorous {

    static {
        eatProbability.put(Rabbit.class, 70);
        eatProbability.put(Mouse.class, 90);
        eatProbability.put(Duck.class, 60);
        eatProbability.put(Caterpillar.class, 40);

        weight = 8;
        maxCountOnLocation = 30;
        speed = 2;
        saturation = 2;
    }

}
