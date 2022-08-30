package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;

public class Boar extends Animal implements Herbivorous, Carnivorous {

     public Boar() {
        eatProbability.put("Mouse", 50);
        eatProbability.put("Caterpillar", 90);
        eatProbability.put("Herb", 100);

        weight = 400;
        maxCountOnLocation = 50;
        speed = 2;
        maxSaturation = 50;
    }

}
