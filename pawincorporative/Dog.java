package org.amadeus.pawincorporative;

public class Dog extends Animal{
     int amountOfCommands;

    public Dog(String name, int age, int amountOfCommands) {
        super(name, age);
        this.amountOfCommands = amountOfCommands;
    }

    public Dog(String name, int age) {
        super(name, age);
    }
}
