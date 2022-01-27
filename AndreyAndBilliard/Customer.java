package com.company;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getProductQuantity() {
        return productQuantity;
    }

    private Map<String, Integer> productQuantity = new HashMap<>();

    public Customer(String name, Map<String, Integer> productQuantity) {
        this.name = name;
        this.productQuantity = productQuantity;
    }
}
