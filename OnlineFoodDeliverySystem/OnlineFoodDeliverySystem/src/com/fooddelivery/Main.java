package com.fooddelivery;

import com.fooddelivery.controllers.AdminController;
import com.fooddelivery.controllers.CustomerController;
import com.fooddelivery.controllers.OrderController;
import com.fooddelivery.models.Customer;
import com.fooddelivery.models.FoodItem;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        AdminController adminController = new AdminController();
        CustomerController customerController = new CustomerController();
        OrderController orderController = new OrderController();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            // Display main menu to choose between Admin or Customer
            System.out.println("\nMain Menu:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int mainOption = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (mainOption) {
                case 1:  // Admin Menu
                    boolean adminExit = false;
                    while (!adminExit) {
                        System.out.println("\nAdmin Menu:");
                        System.out.println("1. Add Restaurant");
                        System.out.println("2. Add Food Item to Restaurant");
                        System.out.println("3. Remove Food Item from Restaurant");
                        System.out.println("4. View Restaurants and Menus");
                        System.out.println("5. View Orders");
                        System.out.println("6. Add Delivery Person");
                        System.out.println("7. Assign Delivery Person to Order");
                        System.out.println("8. Exit");
                        System.out.print("Choose an option: ");
                        int adminOption = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        int restId;
                        int foodItemId;

                        switch (adminOption) {
                            case 1:  // Add Restaurant
                                System.out.print("Enter Restaurant ID: ");
                                int restaurantId = scanner.nextInt();
                                scanner.nextLine();  // Consume newline
                                System.out.print("Enter Restaurant Name: ");
                                String restaurantName = scanner.nextLine();
                                adminController.addRestaurant(restaurantId, restaurantName);
                                System.out.println("Restaurant added successfully!");
                                break;

                            case 2:  // Add Food Item to Restaurant
                                System.out.print("Enter Restaurant ID: ");
                                restId = scanner.nextInt();
                                System.out.print("Enter Food Item ID: ");
                                foodItemId = scanner.nextInt();
                                scanner.nextLine();  // Consume newline
                                System.out.print("Enter Food Item Name: ");
                                String foodItemName = scanner.nextLine();
                                System.out.print("Enter Food Item Price: ");
                                double price = scanner.nextDouble();
                                adminController.addFoodItem(restId, foodItemId, foodItemName, price);
                                System.out.println("Food item added successfully!");
                                break;

                            case 3:  // Remove Food Item from Restaurant
                                // Code to remove food item (not shown in image)
                                System.out.print("Enter Restaurant ID: ");
                                restId = scanner.nextInt();  // Assign value without redeclaring
                                System.out.print("Enter Food Item ID: ");
                                foodItemId = scanner.nextInt();  // Assign value without redeclaring
                                adminController.removeFoodItem(restId, foodItemId);
                                break;

                            case 4:  // View Restaurants and Menus
                                adminController.viewRestaurantsAndMenus();
                                break;

                            case 5:  // View Orders
                                adminController.viewOrders();
                                break;
                            

                            case 6:  // Add Delivery Person
                                // Code to add delivery person (not shown in image)
                                break;

                            case 7:  // Assign Delivery Person to Order
                                // Code to assign delivery person (not shown in image)
                                break;

                            case 8:  // Exit Admin Menu
                                adminExit = true;
                                break;

                            default:
                                System.out.println("Invalid option! Please try again.");
                        }
                    }
                    break;

                case 2:  // Customer Menu
                    boolean customerExit = false;
                    while (!customerExit) {
                        System.out.println("\nCustomer Menu:");
                        System.out.println("1. Add Customer");
                        System.out.println("2. View Food Items");
                        System.out.println("3. Add Food to Cart");
                        System.out.println("4. View Cart");
                        System.out.println("5. Place Order");
                        System.out.println("6. View Orders");
                        System.out.println("7. Exit");
                        System.out.print("Choose an option: ");
                        int customerOption = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        switch (customerOption) {
                            case 1:  // Add Customer
                                System.out.print("Enter User ID: ");
                                int userId = scanner.nextInt();
                                scanner.nextLine();  // Consume newline
                                System.out.print("Enter Username: ");
                                String username = scanner.nextLine();
                                System.out.print("Enter Contact No.: ");
                                long contactNo = scanner.nextLong();
                                customerController.addCustomer(userId, username, contactNo);
                                System.out.println("Customer created successfully!");
                                break;

                            case 2:  // View Food Items
                                adminController.viewRestaurantsAndMenus();
                                break;

                            case 3:  // Add Food to Cart
                                System.out.print("Enter Customer ID: ");
                                int custId = scanner.nextInt();
                                Customer customer = customerController.getCustomerById(custId);
                                if (customer != null) {
                                    System.out.print("Enter Restaurant ID: ");
                                    int restId = scanner.nextInt();
                                    System.out.print("Enter Food Item ID: ");
                                    int foodId = scanner.nextInt();
                                    System.out.print("Enter Quantity: ");
                                    int quantity = scanner.nextInt();
                                    FoodItem foodItem = adminController.getFoodItemById(restId, foodId);
                                    if (foodItem != null) {
                                        customerController.addFoodToCart(customer, foodItem, quantity);
                                        System.out.println("Food item added to cart!");
                                    } else {
                                        System.out.println("Invalid Food Item ID!");
                                    }
                                } else {
                                    System.out.println("Customer not found!");
                                }
                                break;

                            case 4:  // View Cart
                                System.out.print("Enter Customer ID: ");
                                int ID = scanner.nextInt();
                                Customer Customer = customerController.getCustomerById(ID);
                                customerController.viewCart(Customer);

                                // Code to view cart (not shown in image)
                                break;

                            case 5:  // Place Order
                            System.out.print("Enter Customer ID: ");
                            int customerId = scanner.nextInt();
                            scanner.nextLine();  // Consume newline character
                        
                            // Fetch the customer by ID
                            Customer currentCustomer = customerController.getCustomerById(customerId);
                            if (currentCustomer != null) {
                                // Ask for delivery address
                                System.out.print("Enter Delivery Address: ");
                                String deliveryAddress = scanner.nextLine();
                        
                                // Place the order
                                orderController.placeOrder(currentCustomer, deliveryAddress);
                            } else {
                                System.out.println("Customer not found!");
                            }
                                 break;
                               

                            case 6:  // View Orders
                                // Code to view orders (not shown in image)
                                break;

                            case 7:  // Exit Customer Menu
                                customerExit = true;
                                break;

                            default:
                                System.out.println("Invalid option! Please try again.");
                        }
                    }
                    break;

                case 3:  // Exit Main Menu
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        System.out.println("System exited successfully.");
        scanner.close();
    }
}
