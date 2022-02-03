package org.amadeus.pawincorporative;

public class Animal {
    public String getName() {
        return name;
    }

    private String name;
    private int age;
    private Boolean cleansingStatus = false;

    public void setCleansingStatus(Boolean cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }

    public boolean getCleansingStatus () {
        return cleansingStatus;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
