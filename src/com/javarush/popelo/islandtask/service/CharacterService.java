package com.javarush.popelo.islandtask.service;

import com.javarush.popelo.islandtask.character.Character;
import com.javarush.popelo.islandtask.island.Island;
import com.javarush.popelo.islandtask.island.Location;
import java.util.List;

public interface CharacterService extends Service {

    void performCharactersMove(Island island);

    Location getNewRandomLocation(Character character);

    void validateMoveToLocation(Character character, Location destination);

    int getCharacterCountOnLocation(Character character, Location location);

    List<Character> getCharacterList(Character character, Location location);

    boolean changeCharacterLocation(Character character, Location location);

    void removeCharacterFromLocation(Character character);

    void addCharacterToLocation(Character character, Location location);

}
