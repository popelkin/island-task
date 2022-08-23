package com.javarush.popelo.islandtask.service;

import java.util.Set;

public interface ClassService extends Service {

    Set<Class> getImplementedClasses(String packageName);

    <T> Class<T> getClass(String className, String packageName);

}
