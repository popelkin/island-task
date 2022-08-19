package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Eagle extends Animal implements Carnivorous {

     {
        eatProbability.put(Fox.class, 10);
        eatProbability.put(Rabbit.class, 90);
        eatProbability.put(Mouse.class, 90);
        eatProbability.put(Duck.class, 80);

        weight = 6;
        maxCountOnLocation = 20;
        speed = 3;
        saturation = 1;
    }

}
