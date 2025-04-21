package com.fooddelivery.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private List<FoodItem> menu = new ArrayList<>();

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public List<FoodItem> getMenu() { return menu; }

    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    public boolean removeFoodItem(int foodItemId) {
        // Use removeIf and directly return its result
        return menu.removeIf(foodItem -> foodItem.getId() == foodItemId);
    }
    

    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", name=" + name + "]";
    }
}
