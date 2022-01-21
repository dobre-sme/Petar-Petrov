package com.company;

import java.util.*;

public class ArrayData {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputNums = scan.nextLine().split(" ");
        int[] numbers = new int[inputNums.length];
        String command = scan.nextLine();
        int min = Integer.parseInt(inputNums[0]);
        int max = Integer.parseInt(inputNums[0]);
        for (int i = 0; i < inputNums.length; i++) {
            numbers[i] = Integer.parseInt(inputNums[i]);
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        double average = (min + max) / 2.0;
        List<Integer> remainingNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > average) {
                remainingNumbers.add(numbers[i]);
            }
        }

        switch (command) {
            case "Min":
                min = max;
                for (int i = 0; i < remainingNumbers.size(); i++) {
                    if (remainingNumbers.get(i) < min) {
                        min = remainingNumbers.get(i);
                    }
                }
                System.out.println(min);
                break;
            case "Max":
                System.out.println(max);
                break;
            case "All":
                while (remainingNumbers.size() > 0) {
                    min = max;
                    int minIndex = 0;
                    for (int i = 0; i < remainingNumbers.size(); i++) {
                        if (remainingNumbers.get(i) < min) {
                            min = remainingNumbers.get(i);
                            minIndex = i;
                        }
                    }
                    remainingNumbers.remove(minIndex);
                    System.out.print(min + " ");
                }
                break;
        }
    }
}