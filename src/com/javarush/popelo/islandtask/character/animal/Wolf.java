package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Wolf extends Animal implements Carnivorous {

   public Wolf() {
        eatProbability.put("Horse", 10);
        eatProbability.put("Deer", 15);
        eatProbability.put("Rabbit", 60);
        eatProbability.put("Mouse", 80);
        eatProbability.put("Goat", 60);
        eatProbability.put("Sheep", 70);
        eatProbability.put("Boar", 15);
        eatProbability.put("Buffalo", 10);
        eatProbability.put("Duck", 40);

        weight = 50;
        maxCountOnLocation = 30;
        speed = 3;
        maxSaturation = 8;
    }

}
