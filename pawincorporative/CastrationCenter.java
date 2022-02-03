package org.amadeus.pawincorporative;

import java.util.ArrayList;
import java.util.List;

public class CastrationCenter extends Center {
    List<Animal> animalList = new ArrayList<>();
    public CastrationCenter(String name, List<Animal> animalList) {
        super(name);
        this.animalList = animalList;
    }
}
