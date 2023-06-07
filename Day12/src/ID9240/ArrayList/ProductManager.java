package ID9240.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.NumberFormatException;

class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ProductManager() {
    }

    public String inputName() {
        String name;
        do {
            System.out.print("Enter Name Product : ");
            name = scanner.nextLine();
            if (name.isEmpty()) System.out.println("Name cannot null!");
        } while (name.isEmpty());
        return name;
    }

    public float inputPrice() {
        String price;
        do {
            System.out.print("Enter Price Product : ");
            price = scanner.nextLine();
            if (price == null) System.out.println("Price cannot null!");
        } while (price == null);
        try {
            return Float.parseFloat(price);
        } catch (NumberFormatException e) {
            System.out.println("Price only can has number!");
            return inputPrice();
        }
    }

    public Product creatProduct() {
        String name = inputName();
        float price = inputPrice();
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
