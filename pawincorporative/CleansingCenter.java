package org.amadeus.pawincorporative;

import java.util.ArrayList;
import java.util.List;

public class CleansingCenter extends Center {
    List<Animal> animalList = new ArrayList<>();

    public CleansingCenter(String name, List<Animal> animals) {
        super(name);
        this.animalList = animals;
    }
}
