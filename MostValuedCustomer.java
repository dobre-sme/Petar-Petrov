package com.company;

import java.util.*;

public class MostValuedCustomer {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String productPrice = scan.nextLine();
        Map<String, Double> productsPrice = new HashMap<>();
        List<String> customers = new ArrayList<>();
        while(!productPrice.equals("Shop is open")) {
            String product = productPrice.split(" ")[0];
            double price = Double.parseDouble(productPrice.split(" ")[1]);
            productsPrice.put(product, price);
            productPrice = scan.nextLine();
        }
        String input = scan.nextLine();
        Map<String, Double> totalSpends = new HashMap<>();
        Map<String, List<String>> customerProducts = new HashMap<>();
        double biggestSpend = 0.0;
        String biggestSpender = "";
        while (!input.equals("Print")) {
            double currentTotalSpends = 0.0;
            if (!input.equals("Discount")) {
                String customer = input.split(": ")[0];
                String productsString = input.split(": ")[1];
                String[] products = productsString.split(", ");
                List<String> currentProducts = new ArrayList<>();
                customers.add(customer);
                for (int i = 0; i < products.length; i++) {
                    currentProducts.add(products[i]);
                    currentTotalSpends += productsPrice.get(products[i]);
                }
                totalSpends.put(customer, currentTotalSpends);
                if (currentTotalSpends > biggestSpend) {
                    biggestSpend = currentTotalSpends;
                    biggestSpender = customer;
                }
                customerProducts.put(customer, currentProducts);
            } else {

            }
            input = scan.nextLine();
        }
        System.out.printf("Biggest spender is: %s", biggestSpender);
        System.out.println();
        System.out.println("^Products bought:");
        for (int i = 0; i < customerProducts.get(biggestSpender).size(); i++) {
            String product = customerProducts.get(biggestSpender).get(i);
            double price = productsPrice.get(customerProducts.get(biggestSpender).get(i));
            System.out.printf("^^^%s: %.2f", product, price);
            System.out.println();
        }
        System.out.printf("Total: %.2f", totalSpends.get(biggestSpender));
    }
}
