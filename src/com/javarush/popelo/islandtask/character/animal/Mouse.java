package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.plant.Herb;

public class Mouse extends Animal implements Herbivorous, Carnivorous {

    public Mouse() {
        eatProbability.put("Caterpillar", 90);
        eatProbability.put("Herb", 100);

        weight = 0.05;
        maxCountOnLocation = 500;
        speed = 1;
        saturation = 0.01;
    }

}
