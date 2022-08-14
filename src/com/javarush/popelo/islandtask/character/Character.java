package com.javarush.popelo.islandtask.character;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Character {

    protected static double weight;
    protected static int maxCountOnLocation;
    protected static int speed;
    protected static double saturation;

    private final static String ANIMAL_PACKAGE = "com.javarush.popelo.islandtask.character.animal";
    private final static String PLANT_PACKAGE = "com.javarush.popelo.islandtask.character.plant";

    /**
     * @return Map
     */
    public static Map<String, Class> getAnimals() {
        return getImplementedClasses(ANIMAL_PACKAGE);
    }

    /**
     * @return Map
     */
    public static Map<String, Class> getPlants() {
        return getImplementedClasses(PLANT_PACKAGE);
    }

    /**
     *
     * @param packageName
     * @return Map
     */
    private static Map<String, Class> getImplementedClasses(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        String finalPackageName = packageName;

        return reader
                .lines()
                .map(line -> getClass(line, finalPackageName))
                .collect(Collectors.toMap(k -> k.getSimpleName(), v -> v));
    }

    /**
     * @param className
     * @param packageName
     * @return Class
     */
    private static Class getClass(String className, String packageName) {
        String name = packageName + "." + className.substring(0, className.lastIndexOf('.'));

        try {
            return Class.forName(name);

        } catch (Exception e) {
            throw new RuntimeException("Can't load class: " + name, e);
        }
    }

}
