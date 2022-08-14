package com.javarush.popelo.islandtask.init;

public final class Loader {

    private final String configFile = "com.javarush.popelo.islandtask.configs.config.json";
    private static Loader instance;

    /**
     * @return Loader
     */
    public static Loader getInstance() {
        if (instance == null) {
            instance = new Loader();
        }

        return instance;
    }



}
