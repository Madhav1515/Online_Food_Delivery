package com.fooddelivery.services;

import com.fooddelivery.models.Customer;
import com.fooddelivery.models.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addFoodToCart(Customer customer, FoodItem foodItem, int quantity) {
        customer.getCart().addItem(foodItem, quantity);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getUserId() == id) {
                return customer;
            }
        }
        return null; // Return null if customer not found
    }
}
