package com.company;

import java.util.*;

public class AdvertisementMessage {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countMessages = Integer.parseInt(scan.nextLine());
        List<String> phrases = new ArrayList<>();
        phrases.add("Excellent product.");
        phrases.add("Such a great product.");
        phrases.add("I always use that product.");
        phrases.add("Best product of its category.");
        phrases.add("Exceptional product.");
        phrases.add("I can’t live without this product.");
        List<String> events = new ArrayList<>();
        events.add("Now I feel good.");
        events.add("I have succeeded with this product.");
        events.add("Makes miracles. I am happy of the results!");
        events.add("I cannot believe but now I feel awesome.");
        events.add("Try it yourself, I am very satisfied.");
        events.add("I feel great!");
        List<String> authors = new ArrayList<>();
        authors.add("Annie");
        authors.add("Diana");
        authors.add("Petya");
        authors.add("Stella");
        authors.add("Elena");
        authors.add("Katya");
        authors.add("Iva");
        authors.add("Eva");
        List<String> cities = new ArrayList<>();
        cities.add("Burgas");
        cities.add("Sofia");
        cities.add("Plovdiv");
        cities.add("Varna");
        cities.add("Ruse");

        for (int i = 0; i < countMessages; i++) {
            int randomPhrase = (int) (Math.random() * phrases.size());
            int randomEvent = (int) (Math.random() * events.size());
            int randomAuthor = (int) (Math.random() * authors.size());
            int randomCity = (int) (Math.random() * cities.size());

            System.out.println(
                    phrases.get(randomPhrase) + " "
                            + events.get(randomEvent) + " "
                            + authors.get(randomAuthor) + " - "
                            + cities.get(randomCity)
            );
        }
    }
}

