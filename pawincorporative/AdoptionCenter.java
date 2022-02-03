package org.amadeus.pawincorporative;

import java.util.ArrayList;
import java.util.List;

public class AdoptionCenter extends Center {
    List<Animal> animalList = new ArrayList<>();

    public AdoptionCenter(String name, List<Animal> animalList) {
        super(name);
        this.animalList = animalList;
    }

}
