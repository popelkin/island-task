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

    private RandomizerService() {
        throw new IllegalStateException("Utility class");
    }
    public static int getRandomInt(int max) {
        return random.nextInt(max + 1);
    }

    public static int getRandomInt(int min, int max) {
        max += 1;
        return random.nextInt(max - min) + min;
    }

}
