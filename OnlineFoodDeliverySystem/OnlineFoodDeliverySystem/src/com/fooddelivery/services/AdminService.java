package com.fooddelivery.services;

import com.fooddelivery.models.FoodItem;
import com.fooddelivery.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    private List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void addFoodItem(int restaurantId, FoodItem foodItem) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == restaurantId) {
                restaurant.addFoodItem(foodItem);
            }
        }
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
