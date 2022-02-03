package org.amadeus.pawincorporative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AnimalCenterManager {
    Map<String, CleansingCenter> cleansingCenters = new HashMap<>();
    Map<String, AdoptionCenter> adoptionCenters = new HashMap<>();
    Map<String, CastrationCenter> castrationCenters = new HashMap<>();
    Map<Animal, String> animalAndCorrespondingAdoptionCenter = new HashMap<>();

    List<String> adoptedAnimalsNames = new ArrayList<>();
    List<String> cleansedAnimalsNames = new ArrayList<>();
    List<String> castratedAnimalsNames = new ArrayList<>();

    void registerCleansingCenter(String name) {
        CleansingCenter cleansingCenter = new CleansingCenter(name, new ArrayList<>());
        this.cleansingCenters.put(name, cleansingCenter);
    }

    void registerAdoptionCenter(String name) {
        AdoptionCenter adoptionCenter = new AdoptionCenter(name, new ArrayList<>());
        this.adoptionCenters.put(name, adoptionCenter);
    }

    void registerCastrationCenter(String name) {
        CastrationCenter castrationCenter = new CastrationCenter(name, new ArrayList<>());
        this.castrationCenters.put(name, castrationCenter);
    }

    void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, learnedCommands);
        adoptionCenters.get(adoptionCenterName).animalList.add(dog);
    }

    void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, intelligenceCoefficient);
        adoptionCenters.get(adoptionCenterName).animalList.add(cat);
    }

    void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        for (int i = 0; i < adoptionCenters.get(adoptionCenterName).animalList.size(); i++) {
            if (!adoptionCenters.get(adoptionCenterName).animalList.get(i).getCleansingStatus()) {
                cleansingCenters.get(cleansingCenterName).animalList.add(adoptionCenters.get(adoptionCenterName).animalList.get(i));
                animalAndCorrespondingAdoptionCenter.put(adoptionCenters.get(adoptionCenterName).animalList.get(i), adoptionCenterName);
                adoptionCenters.get(adoptionCenterName).animalList.remove(i);
                i--;
            }
        }
    }

    void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        for (int i = 0; i < adoptionCenters.get(adoptionCenterName).animalList.size(); i++) {
            if (!adoptionCenters.get(adoptionCenterName).animalList.get(i).getCleansingStatus()) {
                castrationCenters.get(castrationCenterName).animalList.add(adoptionCenters.get(adoptionCenterName).animalList.get(i));
                animalAndCorrespondingAdoptionCenter.put(adoptionCenters.get(adoptionCenterName).animalList.get(i), adoptionCenterName);
                adoptionCenters.get(adoptionCenterName).animalList.remove(i);
                i--;
            }
        }
    }

    void cleanse(String cleansingCenterName) {
        for (int i = 0; i < cleansingCenters.get(cleansingCenterName).animalList.size(); i++) {
            cleansingCenters.get(cleansingCenterName).animalList.get(i).setCleansingStatus(true);
            String adoptionCenterName = animalAndCorrespondingAdoptionCenter.get(cleansingCenters.get(cleansingCenterName).animalList.get(i));
            adoptionCenters.get(adoptionCenterName).animalList.add(cleansingCenters.get(cleansingCenterName).animalList.get(i));
            cleansedAnimalsNames.add(cleansingCenters.get(cleansingCenterName).animalList.get(i).getName());
            cleansingCenters.get(cleansingCenterName).animalList.remove(i);
            i--;
        }
    }

    void adopt(String adoptionCenterName) {
        for (int i = 0; i < adoptionCenters.get(adoptionCenterName).animalList.size(); i++) {
            if (adoptionCenters.get(adoptionCenterName).animalList.get(i).getCleansingStatus()) {
                adoptedAnimalsNames.add(adoptionCenters.get(adoptionCenterName).animalList.get(i).getName());
                adoptionCenters.get(adoptionCenterName).animalList.remove(i);
                i--;
            }
        }
    }

    void castrate(String castrationCenterName) {
        for (int i = 0; i < castrationCenters.get(castrationCenterName).animalList.size(); i++) {
            String adoptionCenterName = animalAndCorrespondingAdoptionCenter.get(castrationCenters.get(castrationCenterName).animalList.get(i));
            adoptionCenters.get(adoptionCenterName).animalList.add(castrationCenters.get(castrationCenterName).animalList.get(i));
            castratedAnimalsNames.add(castrationCenters.get(castrationCenterName).animalList.get(i).getName());
            castrationCenters.get(castrationCenterName).animalList.remove(i);
            i--;
        }
    }

    void castrationStatistics() {
        System.out.println("Paw Inc. Regular Castration Statistics");
        System.out.print("Castration Centers: ");
        System.out.println(castrationCenters.size());
        System.out.print("Castrated Animals: ");
        java.util.Collections.sort(castratedAnimalsNames);
        if (castratedAnimalsNames.size() > 0) {
            for (int i = 0; i < castratedAnimalsNames.size(); i++) {
                if (i == castratedAnimalsNames.size() - 1) {
                    System.out.print(castratedAnimalsNames.get(i));
                    System.out.println();
                } else {
                    System.out.print(castratedAnimalsNames.get(i) + ", ");
                }
            }
        } else {
            System.out.print("None");
        }
    }

    void printStatistics() {
        System.out.println("Paw Incorporative Regular Statistics");
        System.out.printf("Adoption Centers: %d%n", adoptionCenters.size());
        System.out.printf("Cleansing Centers: %d%n", cleansingCenters.size());
        java.util.Collections.sort(adoptedAnimalsNames);
        System.out.print("Adopted Animals: ");
        if (adoptedAnimalsNames.size() > 0) {
            for (int i = 0; i < adoptedAnimalsNames.size(); i++) {
                if (i == adoptedAnimalsNames.size() - 1) {
                    System.out.print(adoptedAnimalsNames.get(i));
                } else {
                    System.out.print(adoptedAnimalsNames.get(i) + ", ");
                }
            }
        } else {
            System.out.printf("None%n");
        }
        java.util.Collections.sort(cleansedAnimalsNames);
        System.out.print("Cleansed Animals: ");
        if (cleansedAnimalsNames.size() > 0) {
            for (int i = 0; i < cleansedAnimalsNames.size(); i++) {
                if (i == cleansedAnimalsNames.size() - 1) {
                    System.out.print(cleansedAnimalsNames.get(i));
                } else {
                    System.out.print(cleansedAnimalsNames.get(i) + ", ");
                }
            }
        } else {
            System.out.printf("None%n");
        }

        int adoptionAwaitingAnimalsCounter = 0;
        int cleansingAwaitingAnimalsCounter = 0;
        for (String s : adoptionCenters.keySet()) {
            for (int i = 0; i < adoptionCenters.get(s).animalList.size(); i++) {
                if (adoptionCenters.get(s).animalList.get(i).getCleansingStatus()) {
                    adoptionAwaitingAnimalsCounter += 1;
                }
            }
        }
        for (String s : cleansingCenters.keySet()) {
            int currentAwaitingForCleansing = cleansingCenters.get(s).animalList.size();
            cleansingAwaitingAnimalsCounter += currentAwaitingForCleansing;
        }
        System.out.printf("Animals Awaiting Adoption: %d%n", adoptionAwaitingAnimalsCounter);
        System.out.printf("Animals Awaiting Cleansing: %d%n", cleansingAwaitingAnimalsCounter);
    }

}
