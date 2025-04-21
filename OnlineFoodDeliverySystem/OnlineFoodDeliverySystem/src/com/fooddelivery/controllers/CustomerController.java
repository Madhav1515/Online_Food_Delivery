package com.fooddelivery.controllers;

import java.util.Map;

import com.fooddelivery.models.Cart;
import com.fooddelivery.models.Customer;
import com.fooddelivery.models.FoodItem;
import com.fooddelivery.services.CustomerService;

public class CustomerController {
    private CustomerService customerService = new CustomerService();

    public void addCustomer(int id, String name, long contactNo) {
        Customer customer = new Customer(id, name, contactNo);
        customerService.addCustomer(customer);
        System.out.println("Customer added: " + customer);
    }

    public void addFoodToCart(Customer customer, FoodItem foodItem, int quantity) {
        customerService.addFoodToCart(customer, foodItem, quantity);
        System.out.println("Added food item to cart: " + foodItem);
    }

    public Customer getCustomerById(int id) {
        return customerService.getCustomerById(id);
    }

    public void viewCart(Customer customer) {
    Cart cart = customer.getCart();  // Get the customer's cart
    if (cart.isEmpty()) {
        System.out.println("Your cart is empty!");
    } else {
        System.out.println("Your cart:");
        for (Map.Entry<FoodItem, Integer> entry : cart.getItems().entrySet()) {
            FoodItem foodItem = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(foodItem.getName() + " x " + quantity + " - Rs. " + (foodItem.getPrice() * quantity));
        }
        System.out.println("Total: Rs. " + cart.getTotalPrice());
    }
}

}
