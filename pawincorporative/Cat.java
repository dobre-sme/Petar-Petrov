package org.amadeus.pawincorporative;

public class Cat extends Animal {
    int intelligenceCoefficient;

    public Cat(String name, int age, int intelligenceCoefficient) {
        super(name, age);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    public Cat(String name, int age) {
        super(name, age);
    }
}
