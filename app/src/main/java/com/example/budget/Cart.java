package com.example.budget;

import java.util.HashMap;

public class Cart {
    private HashMap<String, Integer> cart;
    public Cart() {
        cart = new HashMap<>();
        cart.put("Strawberry", 0);
        cart.put("Spinach", 0);
        cart.put("Carrot", 0);
    }
    public void addItem(String name) {
        cart.put(name, cart.get(name) + 1);
    }
    public double calcCost() {
        double total = cart.get("Strawberry") * 3;
        total += cart.get("Spinach") * 3.5;
        total += cart.get("Carrot") * .99;
        return Math.round(total * 100.0) / 100.0;
    }
    public HashMap<String, Integer> getCart() {
        return cart;
    }
}
