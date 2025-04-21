package com.fooddelivery.models;

public class Customer extends User {
    private Cart cart;

    public Customer(int userId, String username, long contactNo) {
        super(userId, username, contactNo);
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(FoodItem foodItem, int quantity) {
        cart.addItem(foodItem, quantity);
    }

    public void viewCart() {
        System.out.println(cart.toString());
    }
}
