package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Bear extends Animal implements Carnivorous {

    public Bear() {
        eatProbability.put("Boa", 80);
        eatProbability.put("Horse", 40);
        eatProbability.put("Deer", 80);
        eatProbability.put("Rabbit", 80);
        eatProbability.put("Mouse", 90);
        eatProbability.put("Goat", 70);
        eatProbability.put("Sheep", 70);
        eatProbability.put("Boar", 50);
        eatProbability.put("Buffalo", 20);
        eatProbability.put("Duck", 10);

        weight = 500;
        maxCountOnLocation = 5;
        speed = 2;
        maxSaturation = 80;
    }

}
