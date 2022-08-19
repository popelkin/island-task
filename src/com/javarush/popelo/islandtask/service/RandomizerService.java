package com.javarush.popelo.islandtask.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomizerService {

    private static Random random;

    static {
        try {
            random = SecureRandom.getInstanceStrong();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static int getRandomInt(int value) {
        return random.nextInt(value + 1);
    }

}
