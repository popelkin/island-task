package com.javarush.popelo.islandtask.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassServiceImpl implements ClassService {

    public Set<Class> getImplementedClasses(String packageName) {
        InputStream stream = java.lang.ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        String finalPackageName = packageName;

        return reader
                .lines()
                .map(line -> getClass(line, finalPackageName))
                .collect(Collectors.toSet());
    }

    public <T> Class<T> getClass(String className, String packageName) {
        String name = packageName + "." + className.substring(0, className.lastIndexOf('.'));

        try {
            return (Class<T>) Class.forName(name);

        } catch (Exception e) {
            throw new RuntimeException("Can't load class: " + name, e);
        }
    }

}
