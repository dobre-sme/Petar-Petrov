package com.company;

import java.util.*;

public class LambadaExpressions {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, String> objectProperty = new HashMap<>();
        List<String> selectorObjects = new ArrayList<>();
        int danceCounter = 0;
        while (!input.equals("lambada")) {
            if (!input.equals("dance")) {
                String[] selectorObjectProperty = input.split(" => ");
                String selector = selectorObjectProperty[0];
                String currentString = selectorObjectProperty[1];
                String[] objectAndProperty = currentString.split("\\.");
                String selectorObject = objectAndProperty[0];
                String property = objectAndProperty[1];
                if (!objectProperty.containsKey(selectorObject)) {
                    objectProperty.put(selectorObject, property);
                    selectorObjects.add(selectorObject);
                } else {
                    objectProperty.put(selectorObject, property);
                }
            } else {
                danceCounter++;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < selectorObjects.size(); i++) {
            String object = selectorObjects.get(i);
            String property = objectProperty.get(object);
            System.out.print(object + " => ");
            for (int j = 0; j <= danceCounter; j++) {
                System.out.print(object + ".");
            }
            System.out.print(property);
            System.out.println();
        }
    }
}
