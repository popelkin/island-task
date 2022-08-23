package com.javarush.popelo.islandtask.service;

public interface RandomizerService extends Service {

    int getRandomInt(int max);

    int getRandomInt(int min, int max);

}
