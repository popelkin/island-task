package com.javarush.popelo.islandtask.character.animal;

import com.javarush.popelo.islandtask.behavior.Carnivorous;
import com.javarush.popelo.islandtask.behavior.Herbivorous;
import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.plant.Herb;

public class Duck extends Animal implements Herbivorous, Carnivorous {

     {
        eatProbability.put(Caterpillar.class, 90);
        eatProbability.put(Herb.class, 100);

        weight = 1;
        maxCountOnLocation = 200;
        speed = 4;
        saturation = 0.15;
    }

}
