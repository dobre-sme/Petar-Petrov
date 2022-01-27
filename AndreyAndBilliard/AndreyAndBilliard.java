package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AndreyAndBilliard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfEntities = Integer.parseInt(scanner.nextLine());
        Map<String, Double> entityAndPrice = new HashMap<>();
        Map<String, String> clientAndProduct = new HashMap<>();
        for (int i = 0; i < amountOfEntities; i++) {
            String[] entityPrice = scanner.nextLine().split("-");
            entityAndPrice.put(entityPrice[0], Double.parseDouble(entityPrice[1]));
        }
        String input = scanner.nextLine();
        List<Customer> customers = new ArrayList<>();
        while (!input.equals("end of clients")) {
            String[] clientAndEntityAmount = input.split("-");
            String client = clientAndEntityAmount[0];
            String[] entityAndAmount = clientAndEntityAmount[1].split(",");
            String entity = entityAndAmount[0];
            int amount = Integer.parseInt(entityAndAmount[1]);
            if (entityAndPrice.containsKey(entity)) {
                Map<String, Integer> productAndAmount = new HashMap<>();
                clientAndProduct.put(client, entity);
                productAndAmount.put(entity, amount);
                Customer customer = new Customer(client, productAndAmount);
                customers.add(customer);
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < customers.size(); i++) {
            String firstName = customers.get(i).getName();
            for (int j = 0; j < customers.size(); j++) {
                String secondName = customers.get(j).getName();
                if (firstName.compareTo(secondName) < 0) {
                    Customer customer = customers.get(i);
                    customers.set(i, customers.get(j));
                    customers.set(j, customer);
                }
            }
        }
        double totalBill = 0.0;
        for (int i = 0; i < customers.size(); i++) {
            String name = customers.get(i).getName();
            int amount = customers.get(i).getProductQuantity().get(clientAndProduct.get(name));
            double bill = amount * entityAndPrice.get(clientAndProduct.get(name));
            totalBill += bill;
            System.out.println(name);
            System.out.printf("-- %s - %d%n", clientAndProduct.get(name), amount);
            System.out.printf("Bill: %.2f%n", bill);
        }
        System.out.printf("Total bill: %.2f", totalBill);
    }
}