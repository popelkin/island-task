package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Rabbit extends Animal implements Herbivorous {

    public Rabbit() {
        eatProbability.put("Herb", 100);

        weight = 2;
        maxCountOnLocation = 150;
        speed = 2;
        maxSaturation = 0.45;
    }

}
