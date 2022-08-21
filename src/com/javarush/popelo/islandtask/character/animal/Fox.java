package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Fox extends Animal implements Carnivorous {

    public Fox() {
        eatProbability.put("Rabbit", 70);
        eatProbability.put("Mouse", 90);
        eatProbability.put("Duck", 60);
        eatProbability.put("Caterpillar", 40);

        weight = 8;
        maxCountOnLocation = 30;
        speed = 2;
        saturation = 2;
    }

}
