package com.fooddelivery.services;

import com.fooddelivery.models.Order;
import com.fooddelivery.models.Customer;
import com.fooddelivery.models.FoodItem;
import com.fooddelivery.models.DeliveryPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {
    private List<Order> orders = new ArrayList<>();  // Store all orders

    // Create and save a new order
    public void createOrder(int orderId, Customer customer, Map<FoodItem, Integer> items, String deliveryAddress) {
        // Create a new order
        Order newOrder = new Order(orderId, customer, items, deliveryAddress);
        orders.add(newOrder);  // Save the order
    }

    // Assign a delivery person to an order
    public void assignDeliveryPerson(int orderId, DeliveryPerson deliveryPerson) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setDeliveryPerson(deliveryPerson);
            order.setStatus("Assigned to Delivery Person");
        } else {
            System.out.println("Order not found.");
        }
    }

    // Retrieve an order by ID
    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    // Get a list of all orders
    public List<Order> getAllOrders() {
        return orders;
    }
}
