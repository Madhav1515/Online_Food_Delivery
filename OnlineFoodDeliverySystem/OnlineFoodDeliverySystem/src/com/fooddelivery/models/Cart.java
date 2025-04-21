package com.fooddelivery.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<FoodItem, Integer> items = new HashMap<>();

    public void addItem(FoodItem foodItem, int quantity) {
        items.put(foodItem, quantity);
    }

    public void removeItem(FoodItem foodItem) {
        items.remove(foodItem);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            FoodItem foodItem = entry.getKey();
            int quantity = entry.getValue();
            total += foodItem.getPrice() * quantity;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart [items=" + items + "]";
    }
}
