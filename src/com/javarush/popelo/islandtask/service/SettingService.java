package com.javarush.popelo.islandtask.service;

public final class SettingService {

    private final String configFile = "com.javarush.popelo.islandtask.configs.config.json";
    private static SettingService instance;

    /**
     * @return Loader
     */
    public static SettingService getInstance() {
        if (instance == null) {
            instance = new SettingService();
        }

        return instance;
    }



}
