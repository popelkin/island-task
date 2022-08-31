package com.javarush.popelo.islandtask.service;

import java.util.Random;

public class RandomizerServiceImpl implements RandomizerService {

    private static Random random = new Random();

    public int getRandom(int max) {
        return random.nextInt(max + 1);
    }

    public int getRandom(int min, int max) {
        max += 1;
        return random.nextInt(max - min) + min;
    }

    public double getRandom(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }
}
