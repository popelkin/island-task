package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Boa extends Animal implements Carnivorous {

    public Boa() {
        eatProbability.put("Fox", 15);
        eatProbability.put("Rabbit", 20);
        eatProbability.put("Mouse", 40);
        eatProbability.put("Duck", 10);

        weight = 15;
        maxCountOnLocation = 30;
        speed = 1;
        maxSaturation = 3;

    }

}
