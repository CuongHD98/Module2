package manage;

import product.Product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageProduct {
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ManageProduct() {
    }

    public void writeDataToFile(List<Product> products) {
        try (FileOutputStream fos = new FileOutputStream("Products.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(products);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Product> readDataFromFile() {
        List<Product> products = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("Products.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            products = (List<Product>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public void displayProduct() {
        List<Product> products = readDataFromFile();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public String checkInputString(String typeInput, String regex) {
        while (true) {
            System.out.print("Enter " + typeInput + " : ");
            String inputString = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputString);
            if (matcher.matches()) {
                return inputString;
            } else System.out.println(inputString + " is not a valid " + typeInput + ". Please try again!");
        }
    }

    public Product createProduct() {
        List<Product> products = readDataFromFile();
        String nameMedicine;
        while (true) {
            nameMedicine = checkInputString("nameMedicine", "^[a-zA-Z\\s]+$");
            boolean isSameName = false;
            for (Product product : products) {
                if (product.getName().equals(nameMedicine)) {
                    isSameName = true;
                    break;
                }
            }
            if (!isSameName) break;
        }
        String typeMedicine = checkInputString("typeMedicine (Capsule|Water|Gel)", "^(Capsule|Water|Gel)$");
        int quantity = Integer.parseInt(checkInputString("quantity", "^\\d+$"));
        int expiry = Integer.parseInt(checkInputString("expiry", "^\\d+$"));
        String productsUse = checkInputString("productsUse", "^[a-zA-Z0-9\\.\\s]+");
        float price = Float.parseFloat(checkInputString("price", "^\\d+(\\.\\d+|)$"));
        return new Product(nameMedicine, typeMedicine, quantity, expiry, productsUse, price);
    }

    public void addProduct() {
        List<Product> products = readDataFromFile();
        products.add(createProduct());
        writeDataToFile(products);
    }

    public void editProduct() {
        while (true) {
            List<Product> products = readDataFromFile();
            System.out.println("Menu Edit : ");
            System.out.println("1: EditByID");
            System.out.println("2: EditByName");
            System.out.println("3: ExitEdit");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    int id = Integer.parseInt(checkInputString("ID", "^\\d+$"));
                    int indexID = checkIndexByID(id);
                    if (indexID != -1) {
                        Product newProduct = createProduct();
                        newProduct.setId(id);
                        Product.setCountIDProduct(Product.getCountIDProduct() - 1);
                        products.set(indexID, newProduct);
                        writeDataToFile(products);
                    } else System.out.println("Not found ID!");
                    break;
                case "2":
                    String nameMedicine = checkInputString("nameMedicine", "^[a-zA-Z\\s]+$");
                    int indexName = checkIndexByName(nameMedicine);
                    if (indexName != -1) {
                        Product newProduct = createProduct();
                        newProduct.setId(products.get(indexName).getId());
                        Product.setCountIDProduct(Product.getCountIDProduct() - 1);
                        products.set(indexName, newProduct);
                        writeDataToFile(products);
                    } else System.out.println("Not found Name!");
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public int checkIndexByID(int id) {
        List<Product> products = readDataFromFile();
        for (int i = 0; i < products.size(); i++) {
            boolean isSameID = products.get(i).getId() == id;
            if (isSameID) return i;
        }
        return -1;
    }

    public int checkIndexByName(String name) {
        List<Product> products = readDataFromFile();
        for (int i = 0; i < products.size(); i++) {
            boolean isSameName = products.get(i).getName().equals(name);
            if (isSameName) return i;
        }
        return -1;
    }

    public void deleteProduct() {
        while (true) {
            List<Product> products = readDataFromFile();
            System.out.println("Menu Delete : ");
            System.out.println("1. DeleteByID");
            System.out.println("2. DeleteByName");
            System.out.println("3. ExitDelete");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    int id = Integer.parseInt(checkInputString("ID", "^\\d+$"));
                    int indexID = checkIndexByID(id);
                    if (indexID != -1) {
                        products.remove(indexID);
                        writeDataToFile(products);
                    } else {
                        System.out.println("Not found ID!");
                    }
                    break;
                case "2":
                    String nameMedicine = checkInputString("nameMedicine", "^[a-zA-Z\\s]+$");
                    int indexName = checkIndexByName(nameMedicine);
                    if (indexName != -1) {
                        products.remove(indexName);
                        writeDataToFile(products);
                    } else {
                        System.out.println("Not found ID!");
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public void findMedicine() {
        while (true) {
            List<Product> products = readDataFromFile();
            System.out.println("Menu Find : ");
            System.out.println("1. FindByID");
            System.out.println("2. FindByName");
            System.out.println("3. ExitFind");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    int id = Integer.parseInt(checkInputString("ID", "^\\d+$"));
                    int indexID = checkIndexByID(id);
                    if (indexID != -1) System.out.println(products.get(indexID));
                    else System.out.println("Not found ID!");
                    break;
                case "2":
                    String nameMedicine = checkInputString("nameMedicine", "^[a-zA-Z\\s]+$");
                    int indexName = checkIndexByName(nameMedicine);
                    if (indexName != -1) System.out.println(products.get(indexName));
                    else System.out.println("Not found Name!");
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }
}
