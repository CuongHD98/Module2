import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class ManageCustomer {
    private List<Customer> customers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ManageCustomer() {
    }

    public void display() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public Customer createCustomer() {
        String name = inputName();
        String phone;
        do {
            System.out.print("Enter Phone : ");
            phone = scanner.nextLine();
            if (phone.isEmpty()) System.out.println("Phone cannot null!");
        } while (phone.isEmpty());
        List<Vaccine> listVaccine = new ArrayList<>();
        return new Customer(name, phone, listVaccine);
    }

    public Vaccine createVaccine() {
        String name;
        do {
            System.out.print("Enter Name Vaccine : ");
            name = scanner.nextLine();
            if (name.isEmpty()) System.out.println("Name cannot null!");
        } while (name.isEmpty());
        float price = inputPrice();
        System.out.print("Enter dateVaccine (dd/MM/yyyy) : ");
        Date dateVaccine = inputDate();
        System.out.print("Enter injectVaccine (dd/MM/yyyy) : ");
        Date injectVaccine = inputDate();
        return new Vaccine(name, price, dateVaccine, injectVaccine);


    }

    public String inputName() {
        String name;
        do {
            System.out.print("Enter Name : ");
            name = scanner.nextLine();
            if (name.isEmpty()) System.out.println("Name cannot null!");
        } while (name.isEmpty());
        return name;
    }

    public float inputPrice() {
        String price;
        do {
            System.out.print("Enter Price : ");
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

    public Date inputDate() {
        while (true) {
            try {
                return dateFormat.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Wrong format Date!");
                System.out.print("Enter Date again : ");
            }
        }
    }


    public void addCustomer() {
        Customer customer = createCustomer();
        customers.add(customer);
    }

    public int findIndexByName(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) return i;
        }
        return -1;
    }

    public void addVaccineByName() {
        String name;
        do {
            System.out.print("Enter Name : ");
            name = scanner.nextLine();
            if (name.isEmpty()) System.out.println("Name cannot null!");
        } while (name.isEmpty());
        int index = findIndexByName(name);
        if (index != -1) {
            Vaccine vaccine = createVaccine();
            customers.get(index).addVaccine(vaccine);
        } else System.out.println("Not found Name!");
    }
}
