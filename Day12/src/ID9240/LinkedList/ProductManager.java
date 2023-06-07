package ID9240.LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

class ProductManager {
    private LinkedList<Product> products = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);

    public ProductManager() {
    }

    public Product creatProduct() {
        System.out.print("Enter Name Product : ");
        String name = scanner.nextLine();
        System.out.print("Enter Price Product : ");
        float price = Float.parseFloat(scanner.nextLine());
        return new Product(name, price);
    }

    public int findIndexById(int id) {
        if (!products.isEmpty()) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == id) return i;
            }
        }
        return -1;
    }

    public void display() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void add() {
        Product newProduct = creatProduct();
        products.add(newProduct);
    }

    public void edit() {
        if (products.isEmpty()) {
            System.out.println("Products is Empty!");
        } else {
            System.out.print("Enter ID : ");
            int id = Integer.parseInt(scanner.nextLine());
            Product newProduct = creatProduct();
            Product.count--;
            int checkID = findIndexById(id);
            if (checkID != -1) {
                newProduct.setId(products.get(checkID).getId());
                products.set(checkID, newProduct);
            } else System.out.println("Not found ID!");
        }
    }

    public void delete() {
        if (products.isEmpty()) {
            System.out.println("Products is Empty!");
        } else {
            System.out.print("Enter ID : ");
            int id = Integer.parseInt(scanner.nextLine());
            int checkID = findIndexById(id);
            if (checkID != -1) {
                products.remove(checkID);
            } else System.out.println("Not found ID!");
        }
    }

    public void findProductByName() {
        System.out.print("Enter Name : ");
        String name = scanner.nextLine();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product);
            }
        }
        System.out.println("Not found Name!");
    }

    public void sortForPrice() {
        System.out.println("1.Ascending");
        System.out.println("2.Descending");
        System.out.println("3. Exit");
        System.out.print("Enter choice : ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                products.sort((product1, product2) -> (int) (product1.getPrice() - product2.getPrice()));
                display();
                break;
            case "2":
                products.sort((product1, product2) -> (int) (product2.getPrice() - product1.getPrice()));
                display();
                break;
            case "3":
                return;
            default:
                System.out.println("Not found Choice!");
                sortForPrice();
        }
    }


}
