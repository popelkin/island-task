package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Buffalo extends Animal implements Herbivorous {

    public Buffalo() {
        eatProbability.put("Herb", 100);

        weight = 700;
        maxCountOnLocation = 10;
        speed = 3;
        maxSaturation = 100;
    }

}
