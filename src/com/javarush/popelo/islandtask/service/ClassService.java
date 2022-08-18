package com.javarush.popelo.islandtask.service;

import com.javarush.popelo.islandtask.character.Character;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassService {

    /**
     *
     * @param packageName
     * @return Map
     */
    public static <T> Map<Class<T>, Class<T>> getImplementedClasses(String packageName) {
        InputStream stream = java.lang.ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        String finalPackageName = packageName;

        return reader
                .lines()
                .map(line -> getClass(line, finalPackageName))
                .collect(Collectors.toMap(v -> v, v -> v));
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


