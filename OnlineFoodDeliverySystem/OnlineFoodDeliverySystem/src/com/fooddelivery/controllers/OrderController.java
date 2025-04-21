package com.fooddelivery.controllers;

import com.fooddelivery.models.Customer;
import com.fooddelivery.models.Order;
import com.fooddelivery.models.DeliveryPerson;
import com.fooddelivery.services.OrderService;
import com.fooddelivery.models.FoodItem;
import java.util.Map;

public class OrderController {
    private OrderService orderService = new OrderService();
    private int currentOrderId = 1;

    // Place a new order
    public void placeOrder(Customer customer, String deliveryAddress) {
        if (customer.getCart().isEmpty()) {
            System.out.println("Your cart is empty. Cannot place an order.");
            return;
        }

        // Get items from the customer's cart
        Map<FoodItem, Integer> cartItems = customer.getCart().getItems();
        double totalAmount = customer.getCart().getTotalPrice();

        // Create a new order using cart items
        orderService.createOrder(currentOrderId, customer, cartItems, deliveryAddress);
        currentOrderId++;  // Increment order ID for the next order

        // Clear the customer's cart after placing the order
        //customer.clearCart();
        System.out.println("Order placed successfully!");
    }

    // Assign delivery person to an order
    public void assignDeliveryPerson(int orderId, DeliveryPerson deliveryPerson) {
        orderService.assignDeliveryPerson(orderId, deliveryPerson);
        System.out.println("Delivery person assigned successfully!");
    }

    // View an order's details
    public Order viewOrder(int orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            System.out.println(order.toString());
            return order;
        } else {
            System.out.println("Order not found.");
            return null;
        }
    }
}
