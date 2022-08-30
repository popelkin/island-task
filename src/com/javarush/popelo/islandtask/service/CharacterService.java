package com.javarush.popelo.islandtask.service;

import com.javarush.popelo.islandtask.character.Animal;
import com.javarush.popelo.islandtask.character.Character;
import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;
import java.util.List;

public interface CharacterService extends Service {
    void performCharactersMove(Island island);

    void performCharactersMultiply(Island island);

    void performCharactersEat(Island island);

    Location getNewRandomLocation(Character character);

    void validateMoveToLocation(Character character, Location destination);

    int getCharacterCountOnLocation(Character character, Location location);

    List<Character> getCharacterList(Character character, Location location);

    boolean changeCharacterLocation(Character character, Location location);

    boolean eatCharacter(Character character, Character victim);
    void eatCharacterFailed(Character character);

    boolean multiplyCharacter(Character character);

    boolean dieCharacter(Character character);

    void removeCharacterFromLocation(Character character);

    void addCharacterToLocation(Character character, Location location);

    Character getRandomVictim(Animal animal);

    void updateCharacterSaturation(Character character, double value);

    <T> T createCharacterInstance(Class<T> clazz);
}
