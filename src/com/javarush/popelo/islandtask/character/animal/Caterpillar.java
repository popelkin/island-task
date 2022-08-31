package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.plant.Herb;

public class Caterpillar extends Animal implements Herbivorous {

    public Caterpillar() {
        eatProbability.put("Herb", 100);

        weight = 0.01;
        maxCountOnLocation = 1000;
    }

}
