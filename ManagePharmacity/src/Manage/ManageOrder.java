package Manage;

import File.FilePATH;
import Function.Create;
import Function.IOFile;
import Function.Input;
import Model.Account;
import Model.Medicine;
import Model.Order;
import Model.Validate;

import java.util.List;
import java.util.Scanner;

public class ManageOrder {
    Scanner scanner = new Scanner(System.in);
    Create create = new Create();
    Input input = new Input();
    IOFile<Order> ioFileO = new IOFile<>();
    IOFile<Medicine> ioFileM = new IOFile<>();
    ManageMedicine manageMedicine = new ManageMedicine();

    public ManageOrder() {
    }
    public void displayOrder() {
        List<Order> orders = ioFileO.readDataFromFile(FilePATH.Order_PATH);
        System.out.println("-------------------Order-------------------");
        System.out.printf("%-5s%-20s%-15s%-15s%-15s%-26s%s",
                "ID", "ROLE | NameAccount", "NameCustomer", "Birthday", "Phone", "Email", "\n");

        for (Order order : orders) {
            System.out.printf("%-5s%-20s%-15s%-15s%-15s%-26s%s", order.getId(), order.getAccount().getROLE() + " | " + order.getAccount().getName(),
                    order.getCustomer().getName(), order.getCustomer().getBirthday(),
                    order.getCustomer().getPhone(), order.getCustomer().getEmail(), "\n");
            System.out.println("---ListMedicineBuy---");
            System.out.printf("%-5s%-20s%-10s%-30s%-25s%-10s%-10s%-10s%s",
                    "ID", "Name", "Type", "Effect", "TimesUse", "Quantity", "Price", "TotalPrice", "\n");
            for (Medicine medicine : order.getMedicines()) {
                System.out.printf("%-5s%-20s%-10s%-30s%-25s%-10s%-10s%-10s%s",
                        medicine.getId(), medicine.getName(), medicine.getType(), medicine.getEffect(),
                        medicine.getTimesUse(), medicine.getQuantity(), medicine.getPrice(), medicine.getToTalPrice(), "\n");
            }
            System.out.println("===>> TotalMoneyOrder: " + order.getTotalMoney());
            System.out.println("------------------------------------------");
        }
    }
    public void addOrder(Account account) {
        List<Order> orders = ioFileO.readDataFromFile(FilePATH.Order_PATH);
        Order order = create.order(account);
        while (true) {
            List<Medicine> medicines = ioFileM.readDataFromFile(FilePATH.Medicine_PATH);
            System.out.println("---AddMedicine---");
            System.out.println("1. AddMedicineToOrder");
            System.out.println("2. ExitAdd");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    String nameMedicine = input.inputString("nameMedicine", Validate.NameMedicine_PATTERN);
                    Medicine medicineBuy = manageMedicine.findMedicineByName(nameMedicine);
                    int index = manageMedicine.findIndexByName(nameMedicine);
                    if (medicineBuy != null) {
                        System.out.printf("%-5s%-20s%-10s%-30s%-25s%-10s%-10s%s",
                                "ID", "Name", "Type", "Effect", "TimesUse", "Quantity", "Price", "\n");
                        System.out.printf("%-5s%-20s%-10s%-30s%-25s%-10s%-10s%s",
                                medicineBuy.getId(), medicineBuy.getName(), medicineBuy.getType(), medicineBuy.getEffect(),
                                medicineBuy.getTimesUse(), medicineBuy.getQuantity(), medicineBuy.getPrice(), "\n");
                        int quantityThisMedicine = medicineBuy.getQuantity();
                        int quantityNeedBuy = input.inputInt("quantityNeedBuy", Validate.INT_PATTERN);
                        if (quantityNeedBuy <= quantityThisMedicine) {
                            medicineBuy.setQuantity(quantityNeedBuy);
                            order.addMedicine(medicineBuy);
                            float totalMoney = 0;
                            for (Medicine medicine : order.getMedicines()) {
                                totalMoney += medicine.getToTalPrice();
                            }
                            order.setTotalMoney(totalMoney);
                            medicines.get(index).setQuantity(quantityThisMedicine - quantityNeedBuy);
                            if (medicines.get(index).getQuantity() == 0) medicines.remove(index);
                            ioFileM.writeDataToFile(medicines, FilePATH.Medicine_PATH);
                        } else System.out.println("Quantity larger than Max!");
                    } else System.out.println("Not found NameMedicine!");
                    break;
                case "2":
                    orders.add(order);
                    ioFileO.writeDataToFile(orders, FilePATH.Order_PATH);
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }
    public int findIndexByID(int id) {
        List<Order> orders = ioFileO.readDataFromFile(FilePATH.Order_PATH);
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) return i;
        }
        return -1;
    }
    public void editOrder(Account account) {
        List<Order> orders = ioFileO.readDataFromFile(FilePATH.Order_PATH);
        int id = input.inputInt("id", Validate.INT_PATTERN);
        int index = findIndexByID(id);
        if (index != -1) {
            Order order = create.order(account);
            Order.setCountIDOrder(Order.getCountIDOrder() - 1);
            orders.set(index, order);
            ioFileO.writeDataToFile(orders, FilePATH.Order_PATH);
        } else System.out.println("Not found ID!");
    }
    public void deleteOrder(Account account) {
        List<Order> orders = ioFileO.readDataFromFile(FilePATH.Order_PATH);
        int id = input.inputInt("id", Validate.INT_PATTERN);
        int index = findIndexByID(id);
        if (index != -1) {
            orders.remove(index);
            ioFileO.writeDataToFile(orders, FilePATH.Order_PATH);
        } else System.out.println("Not found ID!");
    }
    public Order findOrderByID(int id) {
        List<Order> orders = ioFileO.readDataFromFile(FilePATH.Order_PATH);
        int index = findIndexByID(id);
        if (index != -1) return orders.get(index);
        return null;
    }
}
