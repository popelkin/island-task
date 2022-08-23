package com.javarush.popelo.islandtask.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ServiceContainer {
    private static final Map<String, Service> services = new HashMap<>();

    private ServiceContainer() {

    }

    public static void set(Service... service) {
        Arrays.stream(service).forEach(s -> {
            String[] r = s.getClass().getSimpleName().split("(?=\\p{Upper})");
            String interfaceName = r[0] + r[1];

            services.put(interfaceName, s);
        });
    }

    public static <T> T get(String name) {
        return (T) services.get(name);
    }

}
