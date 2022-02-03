package org.amadeus.pawincorporative;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        AnimalCenterManager animalCenterManager = new AnimalCenterManager();
        while(!input.equals("Paw Paw Pawah")) {
            String[] commandAndInfo = input.split(" \\| ");
                String command = commandAndInfo[0];
                switch (command) {
                    case "RegisterCleansingCenter":
                        String name = commandAndInfo[1];
                        animalCenterManager.registerCleansingCenter(name);
                        break;
                    case "RegisterAdoptionCenter":
                        name = commandAndInfo[1];
                        animalCenterManager.registerAdoptionCenter(name);
                        break;
                    case "RegisterDog":
                        name = commandAndInfo[1];
                        int age = Integer.parseInt(commandAndInfo[2]);
                        int learnedCommands = Integer.parseInt(commandAndInfo[3]);
                        String adoptionCenterName = commandAndInfo[4];
                        animalCenterManager.registerDog(name, age, learnedCommands, adoptionCenterName);
                        break;
                    case "RegisterCat":
                        name = commandAndInfo[1];
                        age = Integer.parseInt(commandAndInfo[2]);
                        int intelligenceCoefficient = Integer.parseInt(commandAndInfo[3]);
                        adoptionCenterName = commandAndInfo[4];
                        animalCenterManager.registerCat(name, age, intelligenceCoefficient, adoptionCenterName);
                        break;
                    case "SendForCleansing":
                        adoptionCenterName = commandAndInfo[1];
                        String cleansingCenterName = commandAndInfo[2];
                        animalCenterManager.sendForCleansing(adoptionCenterName, cleansingCenterName);
                        break;
                    case "Cleanse":
                        cleansingCenterName = commandAndInfo[1];
                        animalCenterManager.cleanse(cleansingCenterName);
                        break;
                    case "Adopt":
                        adoptionCenterName = commandAndInfo[1];
                        animalCenterManager.adopt(adoptionCenterName);
                        break;
                    case "RegisterCastrationCenter":
                        name = commandAndInfo[1];
                        animalCenterManager.registerCastrationCenter(name);
                        break;
                    case "SendForCastration":
                        adoptionCenterName = commandAndInfo[1];
                        String castrationCenterName = commandAndInfo[2];
                        animalCenterManager.sendForCastration(adoptionCenterName, castrationCenterName);
                        break;
                    case "Castrate":
                        name = commandAndInfo[1];
                        animalCenterManager.castrate(name);
                        break;
                    case "CastrationStatistics":
                        animalCenterManager.castrationStatistics();
                        break;
                }
            input=scan.nextLine();
        }
        animalCenterManager.printStatistics();
    }
}
