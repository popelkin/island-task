package com.javarush.popelo.islandtask.character;

import com.javarush.popelo.islandtask.behavior.*;
import com.javarush.popelo.islandtask.island.Location;
import com.javarush.popelo.islandtask.service.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Animal extends Character implements Move, Eat, Multiply {

    protected Map<String, Integer> eatProbability = new HashMap<>();

    public boolean isHerbivorous() {
        return this instanceof Herbivorous;
    }

    public boolean isCarnivorous() {
        return this instanceof Carnivorous;
    }

    public Map<String, Integer> getEatProbability() {
        return eatProbability;
    }

    @Override
    public void performEat() {
        CharacterService characterService = ServiceContainer.get("CharacterService");
        RandomizerService randomizerService = ServiceContainer.get("RandomizerService");
        int huntTries = randomizerService.getRandom(1, 10);

        while (this.saturation < this.maxSaturation && huntTries-- > 0) {
            Character victim = characterService.getRandomVictim(this);

            int percent = this.getEatProbability().get(victim.getName());
            int random = randomizerService.getRandom(100);

            if (random > percent) {
                characterService.eatCharacterFailed(this);
                continue;
            }

            characterService.eatCharacter(this, victim);
        }
    }

    @Override
    public void performMove() {
        CharacterService characterService = ServiceContainer.get("CharacterService");
        RandomizerService randomizerService = ServiceContainer.get("RandomizerService");
        int maxSpeed = this.getSpeed();
        int speed = randomizerService.getRandom(maxSpeed);

        for (int i = 1; i <= speed; i++) {
            Location newLocation = characterService.getNewRandomLocation(this);

            characterService.changeCharacterLocation(this, newLocation);
        }
    }
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
        LocationService locationService = ServiceContainer.get("LocationService");
        Location location = this.getLocation();
        String name = this.getName();
        Map<String, Class<Animal>> animalsPackage = Character.getCharacterClasses(Character.ANIMAL_PACKAGE);
        Class<Animal> proto = animalsPackage.get(name);

        Animal animal = characterService.createCharacterInstance(proto);

        characterService.addCharacterToLocation(animal, location);
        locationService.updateLocationCharacterStatistic(location, animal, Location.LABEL_MULTIPLY, 1);
    }

}
