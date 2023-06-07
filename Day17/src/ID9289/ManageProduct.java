package ID9289;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProduct {
    private static final String FILENAME = "product.dat";
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        loadData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a product");
            System.out.println("2. Display all products");
            System.out.println("3. Search for a product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    saveData();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            products = (List<Product>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(products);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        Product product = new Product(name, id, price);
        products.add(product);
        System.out.println("Product added: " + product);
    }

    private static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private static void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID to search for: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println(product);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }
}