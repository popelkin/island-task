package com.javarush.popelo.islandtask;

import com.javarush.popelo.islandtask.island.Island;

public class Main {

    public static void main(String[] args) {
        Island island = new Island(10,10);

        island.createLocations();
        island.performCharactersMove();

        System.out.println(island.getStatistic());


        System.out.println("Finish");
    }
}
