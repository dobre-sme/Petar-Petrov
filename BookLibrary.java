package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int booksCounter = Integer.parseInt(scan.nextLine());
        Map<String, Double> authorPriceSum = new HashMap<>();
        List<String> authors = new ArrayList<>();
        for (int i = 0; i < booksCounter; i++) {
            String[] input = scan.nextLine().split(" ");
            String author = input[1];
            double price = Double.parseDouble(input[5]);
            if (authorPriceSum.containsKey(author)) {
                double currentAuthorsSum = authorPriceSum.get(author);
                authorPriceSum.put(author, currentAuthorsSum + price);
            } else {
                authors.add(author);
                authorPriceSum.put(author, price);
            }
        }
        for (int i = 0; i < authors.size(); i++) {
            double firstAuthorsSum = authorPriceSum.get(authors.get(i));
            for (int j = 0; j < authors.size(); j++) {
                double secondAuthorsSum = authorPriceSum.get(authors.get(j));
                if (firstAuthorsSum > secondAuthorsSum) {
                    String currentAuthor = authors.get(i);
                    authors.set(i, authors.get(j));
                    authors.set(j, currentAuthor);
                }
            }
        }
        for (int i = 0; i < authors.size(); i++) {
            System.out.printf("%s -> %.2f", authors.get(i), authorPriceSum.get(authors.get(i)));
            System.out.println();
        }
    }
}