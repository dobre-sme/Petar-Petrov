package com.company;

import java.util.*;

public class Camping {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> personDays = new HashMap<>();
        Map<String, List<String>> personCamper = new HashMap<>();
        List<String> persons = new ArrayList<>();
        while (!input.equals("end")) {
            String[] inputInfo = input.split(" ");
            String personName = inputInfo[0];
            String camperModel = inputInfo[1];
            int days = Integer.parseInt(inputInfo[2]);
            if (!personDays.containsKey(personName)) {
                personDays.put(personName, days);
                persons.add(personName);
                List<String> current = new ArrayList<>();
                current.add(camperModel);
                personCamper.put(personName, current);
            } else {
                int currentDays = personDays.get(personName);
                days = days + currentDays;
                personDays.put(personName, days);
                if (!personCamper.get(personName).contains(camperModel)) {
                    personCamper.get(personName).add(camperModel);
                }
            }
            input = scan.nextLine();
        }

        for (int i = 0; i < persons.size(); i++) {
            for (int j = 0; j < persons.size(); j++) {
                if (personCamper.get(persons.get(i)).size() > personCamper.get(persons.get(j)).size()) {
                    String currentPerson = persons.get(i);
                    persons.set(i, persons.get(j));
                    persons.set(j, currentPerson);
                } else if (personCamper.get(persons.get(i)).size() == personCamper.get(persons.get(j)).size()) {
                    if (persons.get(i).length() < persons.get(j).length()) {
                        String currentPerson = persons.get(i);
                        persons.set(i, persons.get(j));
                        persons.set(j, currentPerson);
                    }
                }
            }
        }

        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i) + ": " + personCamper.get(persons.get(i)).size());
            for (int j = 0; j < personCamper.get(persons.get(i)).size(); j++) {
                System.out.println("***" + personCamper.get(persons.get(i)).get(j));
            }
            System.out.printf("Total stay: %d nights", personDays.get(persons.get(i)));
            System.out.println();
        }
    }
}
