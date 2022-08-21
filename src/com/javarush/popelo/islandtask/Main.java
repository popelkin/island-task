package com.javarush.popelo.islandtask;

import com.javarush.popelo.islandtask.island.Island;

public class Main {

    public static void main(String[] args) {
        Island island = new Island(10,10);

        island.createLocations();

        island.performCharactersMove();

        island.printStatistic();

        System.out.println("Finish");
    }
}
