package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mainMenu();
    }
    public static ArrayList<Product> inventory = getInventory();

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect an option: \n");
            System.out.println("[1] - List all products");
            System.out.println("[2] - Lookup a product by its id");
            System.out.println("[3] - Find all products within a price range");
            System.out.println("[4] - Add a new product");
            System.out.println("[x] - Quit the application");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> listAllProducts();
                case "2" -> lookupProductById();
                case "3" -> findProductsInPriceRange();
                case "4" -> addNewProduct();
                case "x" -> {
                    System.out.println("Exiting application...");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again!");
            }
        }
    }


    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        inventory.add(new Product("product1", 12345, 19.00));
        inventory.add(new Product("product2", 12346, 29.00));
        inventory.add(new Product("product3", 12347, 39.00));
        inventory.add(new Product("product4", 12348, 49.00));
        inventory.add(new Product("product5", 12349, 59.00));

        // this method loads product objects into inventory
        // and its details are not shown
        inventory.sort(Comparator.comparing(Product::getName));
        return inventory;
    }

    public static void listAllProducts() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %-10s %-20s - Price: $%.2f \n", p.getId(), p.getName(), p.getPrice());
        }
    }

    public static void lookupProductById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Product product : getInventory()) {
            if (product.getId() == id) {
                System.out.printf("id: %-10s %-20s - Price: $%.2f \n", product.getId(), product.getName(), product.getPrice());
                return;
            } else {
                System.out.println("Product not found...");
            }
        }
    }

    public static void findProductsInPriceRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Products in price range " + minPrice + " - " + maxPrice + ":");
        for (Product product : getInventory()) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                System.out.printf("id: %-10s %-20s - Price: $%.2f \n", product.getId(), product.getName(), product.getPrice());
            }
        }
    }

    public static void addNewProduct() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        inventory.add(new Product(name, id, price));

        System.out.println("Product added.");
    }
}