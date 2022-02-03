package org.amadeus.pawincorporative;

import java.util.ArrayList;
import java.util.List;

public class Center {
    private String name;

    public List<Animal> getAnimals() {
        return animals;
    }

    private List<Animal> animals = new ArrayList<>();

    public void addAnimal (Animal animal) {
        animals.add(animal);
    }


    public Center(String name) {
        this.name = name;
    }
}
