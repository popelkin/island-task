package com.javarush.popelo.islandtask;

import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.character.Character;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Island island = new Island(10,10);

        island.fillWithLocations();

        System.out.println("Finish");
    }
}
