package com.javarush.popelo.islandtask.service;

public interface RandomizerService extends Service {

    int getRandom(int max);

    int getRandom(int min, int max);

    double getRandom(double min, double max);
}
