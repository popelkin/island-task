package com.javarush.popelo.islandtask.character;

import com.javarush.popelo.islandtask.behavior.Multiply;
import com.javarush.popelo.islandtask.island.Location;
import com.javarush.popelo.islandtask.service.CharacterService;
import com.javarush.popelo.islandtask.service.RandomizerService;
import com.javarush.popelo.islandtask.service.ServiceContainer;

import java.util.List;
import java.util.Map;

public abstract class Plant extends Character implements Multiply {

    @Override
    public void performMultiply() {
        RandomizerService randomizerService = ServiceContainer.get("RandomizerService");
        CharacterService characterService = ServiceContainer.get("CharacterService");
        List<Character> characters = characterService.getCharacterList(this, getLocation());

        if (characters.size() < this.maxCountOnLocation) {
            int count = randomizerService.getRandom(this.maxCountOnLocation - characters.size());

            for (int i = 0; i < count; i++) {
                this.multiply();
            }
        }
    }

    private void multiply() {
        CharacterService characterService = ServiceContainer.get("CharacterService");
        Location location = this.getLocation();
        String name = this.getName();
        Map<String, Class<Plant>> plantsPackage = Character.getCharacterClasses(Character.PLANT_PACKAGE);
        Class<Plant> proto = plantsPackage.get(name);

        Plant plant = characterService.createCharacterInstance(proto);

        characterService.addCharacterToLocation(plant, location);
    }

}
