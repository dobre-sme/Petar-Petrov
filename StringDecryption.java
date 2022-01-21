package com.company;

import java.util.*;

public class StringDecryption {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int skip = Integer.parseInt(input[0]);
        int take = Integer.parseInt(input[1]);
        String[] inputNumbers = scan.nextLine().split(" ");
        List<Integer> validNumbers = new ArrayList<>();
        for (int i = 0; i < inputNumbers.length; i++) {
            int currentNumber = Integer.parseInt(inputNumbers[i]);
            if (currentNumber >= 65 && currentNumber <= 90) {
                validNumbers.add(currentNumber);
            }
        }
        for (int i = skip; i < skip + take; i++) {
            int currentNumber = validNumbers.get(i);
            char currentSymbol = (char)currentNumber;
            System.out.print(currentSymbol);
        }

    }
}