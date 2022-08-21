package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Eagle extends Animal implements Carnivorous {

    public Eagle() {
        eatProbability.put("Fox", 10);
        eatProbability.put("Rabbit", 90);
        eatProbability.put("Mouse", 90);
        eatProbability.put("Duck", 80);

        weight = 6;
        maxCountOnLocation = 20;
        speed = 3;
        saturation = 1;
    }

}
